package org.mayo.edu.tcga.types;

/**
 * The values for each column within a row.   
 */
public class ColumnValues {

    String tag;
    String study;
    String publicId;
    String longname;
    String cdelongname;
    String definition;
    String objClassLongName;
    String objClassPrefName;
    String propLongName;
    String propPrefName;
    String valueDomainName;
    String valueDomainId;
    String valueDomainType;
    String vdDatatype;
    String vmpublicid;
    String meaningdesc;
    String valuemeaning;
    String vmConcepts;
    String validvalue;
    
	public String getTag() {
        return tag;
    }
    public String getStudy() {
        return study;
    }
    public String getPublicId() {
        return publicId;
    }
    public String getLongname() {
        return longname;
    }
    public String getCdelongname() {
        return cdelongname;
    }
    public String getDefinition() {
        return definition;
    }
    public String getObjClassLongName() {
        return objClassLongName;
    }
    public String getObjClassPrefName() {
        return objClassPrefName;
    }
    public String getPropLongName() {
        return propLongName;
    }
    public String getPropPrefName() {
        return propPrefName;
    }
    public String getValueDomainName() {
        return valueDomainName;
    }
    public String getValueDomainId() {
        return valueDomainId;
    }
    public String getValueDomainType() {
        return valueDomainType;
    }
    public String getVdDatatype() {
        return vdDatatype;
    }
    public String getVmpublicid() {
        return vmpublicid;
    }
    public String getVmDesc() {
        return meaningdesc;
    }
    public String getValuemeaning() {
        return valuemeaning;
    }    
    public String getVmConcepts() {
        return vmConcepts;
    }
    public String getValidvalue() {
        return validvalue;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setStudy(String study) {
        this.study = study;
    }
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
    public void setLongname(String longname) {
        this.longname = longname;
    }
    public void setCdelongname(String cdelongname) {
        this.cdelongname = cdelongname;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public void setObjClassLongName(String objClassLongName) {
        this.objClassLongName = objClassLongName;
    }
    public void setObjClassPrefName(String objClassPrefName) {
        this.objClassPrefName = objClassPrefName;
    }
    public void setPropLongName(String propLongName) {
        this.propLongName = propLongName;
    }
    public void setPropPrefName(String propPrefName) {
        this.propPrefName = propPrefName;
    }
    public void setValueDomainName(String valueDomainName) {
        this.valueDomainName = valueDomainName;
    }
    public void setValueDomainId(String valueDomainId) {
        this.valueDomainId = valueDomainId;
    }
    public void setValueDomainType(String valueDomainType) {
        this.valueDomainType = valueDomainType;
    }
    public void setVdDatatype(String vdDatatype) {
        this.vdDatatype = vdDatatype;
    }
    public void setVmpublicid(String vmpublicid) {
        this.vmpublicid = vmpublicid;
    }
    public void setVmDesc(String meaningdesc) {
        this.meaningdesc = meaningdesc;
    }
    public void setValuemeaning(String valuemeaning) {
        this.valuemeaning = valuemeaning;
    }
    public void setVmConcepts(String vmConcepts) {
        this.vmConcepts = vmConcepts;
    }
    public void setValidvalue(String validvalue) {
        this.validvalue = validvalue;
    }

    public void println()  {
        System.out.print( "\t" +tag );
        System.out.print( "\t" +study );
        System.out.print( "\t" +publicId );
        System.out.print( "\t" +longname );
        System.out.print( "\t" +cdelongname );
        System.out.print( "\t" +definition );
        System.out.print( "\t" +objClassLongName );
        System.out.print( "\t" +objClassPrefName );
        System.out.print( "\t" +propLongName );
        System.out.print( "\t" +propPrefName );
        System.out.print( "\t" +valueDomainName );
        System.out.print( "\t" +valueDomainId );
        System.out.print( "\t" +valueDomainType );
        System.out.print( "\t" +vdDatatype );
        System.out.print( "\t" +vmpublicid );
        System.out.print( "\t" +meaningdesc );
        System.out.print( "\t" +valuemeaning );
        System.out.print( "\t" +vmConcepts );
        System.out.print( "\t" +validvalue );
        System.out.print( "\n" );
    }
    
    
    
	
}
