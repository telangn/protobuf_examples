package com.github.telangn.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple message Name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3);

        builder.addAllSampleList(Arrays.asList(4,5,6));

        // Print Protobuf as JSON
        String jsonString = JsonFormat.printer()
                //.includingDefaultValueFields() - options
                .print(builder);
        System.out.println(jsonString);


        // Print Parsed JSON to Protobuf
        SimpleMessage.Builder newBuilder = SimpleMessage.newBuilder();

        JsonFormat.parser().ignoringUnknownFields()
                .merge(jsonString, newBuilder);

        System.out.println(newBuilder);
    }
}
