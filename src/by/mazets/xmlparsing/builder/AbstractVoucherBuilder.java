package by.mazets.xmlparsing.builder;
import by.mazets.xmlparsing.entity.Voucher;

import java.util.HashSet;
import java.util.Set;


public abstract class AbstractVoucherBuilder {

    protected Set<Voucher> vouchers;
    public AbstractVoucherBuilder() {
        vouchers = new HashSet<Voucher>();
    }
    public AbstractVoucherBuilder(Set<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public static AbstractVoucherBuilder createVoucherBuilder(ParserType type) {
        return null;
    }


    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    public abstract void buildSetVouchers(String filename);
}
