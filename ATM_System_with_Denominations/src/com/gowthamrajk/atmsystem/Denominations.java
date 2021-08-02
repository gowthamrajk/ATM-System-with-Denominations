package com.gowthamrajk.atmsystem;

class Denominations
{
    private int twoThousands;
    private int fiveHundreds;
    private int twoHundreds;
    private int hundreds;
    
    public Denominations()
    {
    	super();
    }
    
    public Denominations(int twoThousands, int fiveHundreds, int twoHundreds, int hundreds)
    {
    	super();
        this.twoThousands = twoThousands;
        this.fiveHundreds = fiveHundreds;
        this.twoHundreds = twoHundreds;
        this.hundreds = hundreds;
    }
    
    public int getTwoThousands()
    {
        return twoThousands;
    }
    
    public void setTwoThousands(int twoThousands)
    {
        this.twoThousands = twoThousands;
    }
    
    public int getFiveHundreds()
    {
        return fiveHundreds;
    }
    
    public void setFiveHundreds(int fiveHundreds)
    {
        this.fiveHundreds = fiveHundreds;
    }
    
    public int getTwoHundreds()
    {
        return twoHundreds;
    }
    
    public void setTwoHundreds(int twoHundreds)
    {
        this.twoHundreds = twoHundreds;
    }
    
    public int getHundreds()
    {
        return hundreds;
    }
    
    public void setHundreds(int hundreds)
    {
        this.hundreds = hundreds;
    }
}