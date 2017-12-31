package javafx;

import javafx.beans.property.SimpleStringProperty;

public  class Class_info {
	private final SimpleStringProperty Number;  
    private final SimpleStringProperty Num;  
    private final SimpleStringProperty ClassName;
    private final SimpleStringProperty EnglishName;  
    private final SimpleStringProperty Credit;  
    private final SimpleStringProperty Properties;  
    private final SimpleStringProperty Score;  
   
    public Class_info(String number, String num, String className,String englishName,String credit,String properties,String score) {  
        this.Number = new SimpleStringProperty(number);  
        this.Num = new SimpleStringProperty(num);  
        this.ClassName = new SimpleStringProperty(className);  
        this.EnglishName = new SimpleStringProperty(englishName); 
        this.Credit = new SimpleStringProperty(credit); 
        this.Properties = new SimpleStringProperty(properties); 
        this.Score = new SimpleStringProperty(score); 
    }
    public void setNumber(String number)
    {
    	Number.set(number);
    }
    public String getNumber()
    {
    	return Number.get();
    }
    public void setNum(String num)
    {
    	Num.set(num);
    }
    public String getNum()
    {
    	return Num.get();
    }
    public void setClassName(String className)
    {
    	ClassName.set(className);
    }
    public String getClassName()
    {
    	return ClassName.get();
    }
    public void setEnglishName(String englishName)
    {
    	EnglishName.set(englishName);
    }
    public String getEnglishName()
    {
    	return EnglishName.get();
    }
    public void setCreditName(String credit)
    {
    	Credit.set(credit);
    }
    public String getCredit()
    {
    	return Credit.get();
    }
    public void setProperties(String properties)
    {
    	Properties.set(properties);
    }
    public String getProperties()
    {
    	return Properties.get();
    }
    public void setScore(String score)
    {
        Score.set(score);
    }
    public String getScore()
    {
    	return Score.get();
    }    
}
