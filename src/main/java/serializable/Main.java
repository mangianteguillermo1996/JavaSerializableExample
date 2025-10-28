package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //CREAR LA LISTA
        List<Dog> dogList = new ArrayList<>();

        Dog dog = new Dog("Summer", 2);
        Dog dog2 = new Dog("Susanita", 4);
        Dog dog3 = new Dog("Mimoso", 1);

        dogList.add(dog);
        dogList.add(dog2);
        dogList.add(dog3);

        //GUARDAR LA LISTA
        FileOutputStream fos = null;

        try {

            fos = new FileOutputStream("Salida.txt");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dogList);

            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        //RECUPERAR LA LISTA

        List<Dog>  dogList2 = new ArrayList<>();
        FileInputStream fis = null;

        try {

            fis = new FileInputStream("Salida.txt");

            ObjectInputStream ois = new ObjectInputStream(fis);

            dogList2 = (List<Dog>)ois.readObject();

            ois.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Dog dogs : dogList2) {
            System.out.println(dogs.toString());
        }




    }
}
