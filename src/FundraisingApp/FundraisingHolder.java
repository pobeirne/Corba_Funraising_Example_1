package FundraisingApp;

/**
* FundraisingApp/FundraisingHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Fundraising.idl
* 27 October 2014 16:01:40 o'clock GMT
*/

public final class FundraisingHolder implements org.omg.CORBA.portable.Streamable
{
  public FundraisingApp.Fundraising value = null;

  public FundraisingHolder ()
  {
  }

  public FundraisingHolder (FundraisingApp.Fundraising initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = FundraisingApp.FundraisingHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    FundraisingApp.FundraisingHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return FundraisingApp.FundraisingHelper.type ();
  }

}
