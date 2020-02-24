package com.company;

/*

0929 Enrich the code with functionality
Task: The program enters two file names. And copies the first file to the location specified by the second name.
New task: The program enters two file names. And copies the first file to the location specified by the second name.

If the file (which you want to copy) with the specified name does not exist, then the program should display the inscription "The file does not exist." and read the file name from the console again, and only then read the file for writing.
Requirements:
1. The program should read the file names.
2. The main method should handle exceptions thrown by the getInputStream method. If an exception occurs, the message "The file does not exist." and read the file name from the console again
3. The program should copy the contents of the first file to the second.
4. The getInputStream method should be called in the main method.
5. The getInputStream method cannot be changed.
6. In the main method, it must call the getOutputStream method.
7. The getOutputStream method cannot be changed.

 */

import java.io.*;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.nio.file.attribute.AclFileAttributeView;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                String sourceFileName = reader.readLine();
                String destinationFileName = reader.readLine();
                InputStream fileInputStream;
                try {
                    fileInputStream = getInputStream(sourceFileName);
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не существует.");
                    sourceFileName = reader.readLine();
                    fileInputStream = getInputStream(sourceFileName);
                }
                OutputStream fileOutputStream = getOutputStream(destinationFileName);

                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data);
                }

                fileInputStream.close();
                fileOutputStream.close();
            }


            public static InputStream getInputStream(String fileName) throws IOException {
                return new FileInputStream(fileName);
            }

            public static OutputStream getOutputStream(String fileName) throws IOException {
                return new FileOutputStream(fileName);
            }
        }











