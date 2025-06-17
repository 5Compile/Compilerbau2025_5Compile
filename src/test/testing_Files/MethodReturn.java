public class MethodReturn{
    public int returnInt(){return 10;}
    public void returnVoid(){return;}
    public boolean returnBool(){return true;}
    public char returnChar(){return 'a';}
    public MethodReturn returnMethod(){return new MethodReturn();}
}