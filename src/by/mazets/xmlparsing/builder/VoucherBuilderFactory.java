package by.mazets.xmlparsing.builder;
import by.mazets.xmlparsing.exception.VoucherException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VoucherBuilderFactory {

    private static Logger logger = LogManager.getLogger();

    private static final VoucherBuilderFactory instance = new VoucherBuilderFactory();

    private VoucherBuilderFactory() {};

    public static AbstractVoucherBuilder createVoucherBuilder(ParserType type) throws VoucherException {
        switch (type) {
            case DOM -> {
                return new VoucherDomBuilder();
            }
            case SAX -> {
                return new VoucherSaxBuilder();
            }
            case STAX -> {
                return new VoucherStaxBuilder();
            }
            default -> {
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
            }
        }
    }

    public static VoucherBuilderFactory getInstance() {
        return instance;
    }


}