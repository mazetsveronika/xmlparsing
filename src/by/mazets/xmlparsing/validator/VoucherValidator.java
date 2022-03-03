package by.mazets.xmlparsing.validator;

import by.mazets.xmlparsing.exception.VoucherException;

public interface VoucherValidator {


    boolean validateXML(String xmlFile) throws VoucherException;
}