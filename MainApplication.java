package com.example.googleauth;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.Scanner;

import static com.example.googleauth.Utils.getTOTPCode;

public class MainApplication {

    public static void main(String[] args) throws IOException, WriterException {
      //  String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
        String secretKey = "4GQSXERCENNOQJXJSOMNULVLXHYIBVA5";
        String email = "test@gmail.com";
        String companyName = "Awesome Company";
        String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
        System.out.println(barCodeUrl);
        Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the OTP displayed on your phone");
        String code = scanner.nextLine();
        
        String codeGneratedOTP=getTOTPCode(secretKey);
        System.out.println("Code generated using Automation:"+codeGneratedOTP);
        System.out.println("Code displayed on Mobile:"+codeGneratedOTP);
        
        
        if (code.equals(codeGneratedOTP)) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Invalid 2FA Code");
        }

    }

}
