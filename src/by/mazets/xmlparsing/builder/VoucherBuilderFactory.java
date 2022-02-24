package by.mazets.xmlparsing.builder;

public class VoucherBuilderFactory {
    public enum TypeParser {
        SAX, STAX, DOM
    }
    private VoucherBuilderFactory() {
    }
    public static AbstractVoucherBuilder createVoucherBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new VoucherDomBuilder();
            }
            case STAX -> {
                return new VoucherStaxBuilder();
            }
            case SAX -> {
                return new VoucherSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}