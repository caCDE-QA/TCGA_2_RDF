package org.mayo.edu.tcga;

import java.util.ArrayList;

import org.mayo.edu.tcga.helper.Text;
import org.mayo.edu.tcga.types.ColumnValues;

/**
 * The class constructs the RDF triples.
 *
 */
public class RDF_Composer {

	StringBuffer rdfText;
	
	public RDF_Composer() {
		
	}

	public String getHeader()  {
	    return Text.HEADER + Text.NEW;
	}
	
	public String getRDF(ArrayList<ColumnValues> pharms)  {
		rdfText = new StringBuffer();

		for (ColumnValues pharm : pharms) {
		    setDataElementText(pharm);
		    setValueDomainText(pharm);
		}

		return rdfText.toString();
	}
	
	
	private void setDataElementText(ColumnValues pharm)   {
		String deName = pharm.getPublicId();
		String deContext = pharm.getTag();
		deContext = deContext.replaceAll(" ",  "_");
		String deLabel = pharm.getLongname();
		String deDef = pharm.getDefinition();
		String deVD = pharm.getValueDomainId();

		rdfText.append(Text.URI_ELE +deName +Text.END);
		rdfText.append(Text.CON +deContext +Text.SEMI);
		rdfText.append(Text.TYPE_ELE);
		rdfText.append(Text.LABEL +deLabel +Text.STRING);
		rdfText.append(Text.DEF +deDef +Text.STRING);
		rdfText.append(Text.DEL +deLabel +Text.STRING);
	    rdfText.append(Text.DED +deDef +Text.STRING);
		rdfText.append(Text.DE_NOTE +deName +Text.STRING);
		rdfText.append(Text.DEVD +deVD +Text.SEMI);
		rdfText.append(Text.PER +Text.NEW +Text.NEW);	
	}
	
	
	
	private void setValueDomainText(ColumnValues pharm)   {
        String vdName = pharm.getValueDomainName();
        String vdContext = pharm.getPublicId();
        String vdId = pharm.getValueDomainId();
        String vdType = pharm.getValueDomainType();
        String vdDef = pharm.getVmDesc();
        String vdData = pharm.getVdDatatype();
        
        rdfText.append(Text.URI_ELE +vdId +Text.END);
        rdfText.append(Text.CON +vdContext +Text.SEMI);
        if(vdType.equalsIgnoreCase("enumerated"))   {
            rdfText.append(Text.TYPE_EVD );
        }
        else  {
            rdfText.append(Text.TYPE_VD );
        }
        rdfText.append(Text.LABEL +vdName +Text.STRING);
        rdfText.append(Text.DEF +vdDef +Text.STRING);
        rdfText.append(Text.VD_NOTE +vdId +Text.STRING);
        rdfText.append(Text.TYPE +vdData +Text.STRING);
        rdfText.append(Text.PER +Text.NEW +Text.NEW);   
        
        if(vdType.equalsIgnoreCase("enumerated"))   {
            setPermissibleValues(pharm);
        }
    }
	
    private void setPermissibleValues(ColumnValues pharm)   {
        String pvNames = pharm.getValidvalue();
        String pvMeaning = pharm.getValuemeaning();
        String pvId = pharm.getVmpublicid();
        String pvName = pharm.getValueDomainName();
        String vdId = pharm.getValueDomainId();
        String pvCon = pharm.getVmConcepts();
        String pvDesc = pharm.getVmDesc();

        rdfText.append(Text.URI_ELE +pvId +Text.END);
        rdfText.append(Text.IVD +vdId +Text.SEMI);
        rdfText.append(Text.TYPE_PERM);
        rdfText.append(Text.LABEL +pvNames +Text.STRING);
        rdfText.append(Text.MEAN +pvMeaning +Text.STRING);
        rdfText.append(Text.VM_CON +pvCon +Text.STRING);
        rdfText.append(Text.VM_DESC +pvDesc +Text.STRING);
        rdfText.append(Text.VM_NOTE +pvId +Text.STRING);
        
        rdfText.append(Text.PER +Text.NEW +Text.NEW);   
    }	


}




