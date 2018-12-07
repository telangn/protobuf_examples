package com.github.telangn.protobuf;

import example.simple.Simple.SimpleMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple message Name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3);

        builder.addAllSampleList(Arrays.asList(4,5,6));

        //builder.clearSampleList();
        //builder.setSampleList(3, 42);

        System.out.println("\n"+"builder output..."+"\n");
        System.out.println("\n"+builder.toString()+"\n");

        SimpleMessage message = builder.build();

        try {
            System.out.println("\n"+"Writing to file...."+"\n");
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //send as byte array
        //byte[] bytes = message.toByteArray();

        try {
            System.out.println("\n"+ "Readying from file...."+"\n");
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
