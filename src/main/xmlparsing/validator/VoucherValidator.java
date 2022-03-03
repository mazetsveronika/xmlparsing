package main.xmlparsing.validator;

import main.xmlparsing.exception.VoucherException;

public interface VoucherValidator {


    boolean validateXML(String xmlFile) throws VoucherException;
}