import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization implements Serializable {
    int a;
    String b;
    Serialization(int a, String b){
        this.a=a; this.b=b;
    }
    @Override
    public String toString() {
        return (this.a + "  "+this.b);
    }
    public static void main(String[] args) {
        Serialization s=new Serialization(25, "Divya");
        try{
        FileOutputStream fos=new FileOutputStream("temp.txt");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.close();
        fos.close();

        FileInputStream fis=new FileInputStream("temp.txt");
        ObjectInputStream ois= new ObjectInputStream(fis);
        System.out.println(ois.readObject());
        fis.close();
        ois.close();
        }catch(Exception io){}

    }
}
