package org.mayo.edu.tcga;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.mayo.edu.tcga.helper.Constants;
import org.mayo.edu.tcga.helper.SheetMethods;
import org.mayo.edu.tcga.types.ColumnValues;

/**
 * This program takes a spreadsheet containing TCGA data elements   
 * and converts them into RDF triples.
 * 
 * It hack of a program with no testing and should be treated as such.
 * 
 * TODO - create a config file for name of input/output files
 */
public class TCGA_2_RDF {
	
    static Row row = null;

    static ArrayList<ColumnValues> dataElements;
    
	public static void main (String[] args) {
		try {
			String userDir = System.getProperty("user.dir");
			String fileIn = userDir +"/files/TCGA-DataElements_09202011.xlsx";
		    
		    Workbook wb = WorkbookFactory.create(new File(fileIn));

		    int numSheets = wb.getNumberOfSheets();
		    
		    RDF_Composer composer = new RDF_Composer();
		    String rdfText = composer.getHeader();
		    
		   for (int i = 0; i < numSheets; i++) {
                
    		    Sheet elementSheet = wb.getSheetAt(i);
    		    
    		    dataElements = new ArrayList<ColumnValues>();
    		    dataElements = getElements(elementSheet);

    		    rdfText = rdfText + composer.getRDF(dataElements);
		    }

		    File fileOut = new File( userDir +"/files/tcga.ttl");
			if (!fileOut.exists()) {
				fileOut.createNewFile();
			}
 
			FileWriter fw = new FileWriter(fileOut.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(rdfText);
			bw.close();

			System.out.println("done");
	    }
		catch(Exception e)  {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads the values from the spreadsheet and puts them into the Objects
	 * @param elementSheet
	 * @return
	 */
	private static ArrayList<ColumnValues>  getElements(Sheet elementSheet)  {
	    int numRows;
	    numRows = elementSheet.getPhysicalNumberOfRows();

	    SheetMethods.rowCheck(elementSheet, row, numRows);

	    ArrayList<ColumnValues>  deMap = new ArrayList<ColumnValues> ();
	    for(int r = 1; r < numRows; r++) {
	        row = elementSheet.getRow(r);
	        if(row != null) {
	            String pubId = getCellValue(Constants.COL_PUBID);
	            
	            if(pubId!=null && !pubId.equals(""))  {
            	    ColumnValues de = new ColumnValues();
                    de.setPublicId(pubId);
            		de.setTag(getCellValue(Constants.COL_TAG));
            		de.setStudy(getCellValue(Constants.COL_STUDY));
            		de.setLongname(getCellValue(Constants.COL_LNAME));
            		de.setCdelongname(getCellValue(Constants.COL_CDE_LNAME));
            		de.setDefinition(getCellValue(Constants.COL_DEF));
            		de.setObjClassLongName(getCellValue(Constants.COL_OBJ_LNAME));
            		de.setObjClassPrefName(getCellValue(Constants.COL_OBJ_PNAME));
            		de.setPropLongName(getCellValue(Constants.COL_PROP_LNAME));
            		de.setPropPrefName(getCellValue(Constants.COL_PROP_PNAME));
            		de.setValueDomainId(getCellValue(Constants.COL_VD_ID));
            		de.setValueDomainName(getCellValue(Constants.COL_VD_NAME));
            		de.setValueDomainType(getCellValue(Constants.COL_VD_TYPE));
            		de.setVdDatatype(getCellValue(Constants.COL_VD_DTYPE));
            		de.setVmpublicid(getCellValue(Constants.COL_PM_ID));
    
            		de.setVmDesc(getCellValue(Constants.COL_VD_DEF));
            		de.setValuemeaning(getCellValue(Constants.COL_PM_MEAN));
            		de.setVmConcepts(getCellValue(Constants.COL_PM_CON));
            		de.setValidvalue(getCellValue(Constants.COL_PM_VALUE));
                    
            		deMap.add(de);
	            }
	        }
	    }
    	return deMap;
	}
	
	/**
	 * Useful for debugging
	 */
	private static void printDataElements()  {
		for (ColumnValues dataElement : dataElements) {
		    dataElement.println();
		}
	}
	
	/**
	 * Gets the cell value.  If number, turn into String.  
	 * If not String or number, return blank String.
	 * @param colNum
	 * @return
	 */
	private static String getCellValue(int colNum)  {
	    String cellValue = "";
	    Cell cell = row.getCell(colNum);
	    
	    if(cell.getCellType() == 0)  {
	        cellValue = "" +cell.getNumericCellValue();
	        cellValue = cellValue.replace(".0", "");
	    }
	    else if(cell.getCellType() == 1)
	        cellValue = cell.getStringCellValue();
	    
	    if(cellValue==null)  {
	        cellValue = "";
	    }

	    cellValue = cellValue.replace("\"", "'");
	    return cellValue;
	}
	

}
