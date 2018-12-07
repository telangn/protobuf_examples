package com.github.telangn.protobuf;

import example.complex.Complex.ComplexMessage;
import example.complex.Complex.DummyMessage;
import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {

        DummyMessage oneDummy = createDummyMessage(55, "one dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();
        // singular message field
        builder.setOneDummy(oneDummy);
        // repeated field
        builder.addMultipleDummy(createDummyMessage(66, "second dummy"));
        builder.addMultipleDummy(createDummyMessage(67, "third dummy"));
        builder.addMultipleDummy(createDummyMessage(68, "fourth dummy"));

        builder.addAllMultipleDummy(Arrays.asList(
                createDummyMessage(69, "other dummy"),
                createDummyMessage(70, "another dummy")
        ));

        ComplexMessage message = builder.build();

        System.out.println(message.toString());

        //message.getOneDummy();
        //message.getMultipleDummyList();
    }

    public static DummyMessage createDummyMessage(Integer id, String name) {

        DummyMessage.Builder builder = DummyMessage.newBuilder();
        DummyMessage message = builder.setName(name)
                .setId(id)
                .build();
        return message;
    }
}
