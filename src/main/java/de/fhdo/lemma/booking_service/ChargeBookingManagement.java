package de.fhdo.lemma.booking_service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

public class ChargeBookingManagement extends Contract {
    public static final String BINARY = "";
    public static final String FUNC_CANCELBOOKING = "cancelBooking";
    public static final String FUNC_CREATEBOOKING = "createBooking";
    public static final String FUNC_READBOOKING = "readBooking";
    public static final String FUNC_UPDATEBOOKING = "updateBooking";

    protected ChargeBookingManagement(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected ChargeBookingManagement(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelBooking(BigInteger id) {
        final Function function = new Function(FUNC_CANCELBOOKING, Arrays.<Type>asList(new Uint256(id)), Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createBooking(Booking b) {
        final Function function = new Function(FUNC_CREATEBOOKING, Arrays.<Type>asList(b), Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readBooking(BigInteger id) {
        final Function function = new Function(FUNC_READBOOKING, Arrays.<Type>asList(new Uint256(id)), Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateBooking(BigInteger id, String bookingStart, String bookingEnd, BigInteger verifyCode) {
        final Function function = new Function(FUNC_UPDATEBOOKING,
                Arrays.<Type>asList(new Uint256(id),
                        new Utf8String(bookingStart),
                        new Utf8String(bookingEnd),
                        new Uint256(verifyCode)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static ChargeBookingManagement load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ChargeBookingManagement(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ChargeBookingManagement load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ChargeBookingManagement(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ChargeBookingManagement> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChargeBookingManagement.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ChargeBookingManagement> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChargeBookingManagement.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    public static class Booking extends DynamicStruct {
        public BigInteger id;
        public String bookerId;
        public String parkingSpaceId;
        public String bookingStart;
        public String bookingEnd;
        public String parkingPricePerHour;
        public String chargingPricePerKWh;
        public BigInteger verifyCode;
        public Boolean isCanceled;

        public Booking(BigInteger id, String bookerId, String parkingSpaceId, String bookingStart, String bookingEnd, String parkingPricePerHour, String chargingPricePerKWh, BigInteger verifyCode, Boolean isCanceled) {
            super(new Uint256(id), new Utf8String(bookerId), new Utf8String(parkingSpaceId), new Utf8String(bookingStart), new Utf8String(bookingEnd), new Utf8String(parkingPricePerHour), new Utf8String(chargingPricePerKWh), new Uint256(verifyCode), new Bool(isCanceled));
            this.id = id;
            this.bookerId = bookerId;
            this.parkingSpaceId = parkingSpaceId;
            this.bookingStart = bookingStart;
            this.bookingEnd = bookingEnd;
            this.parkingPricePerHour = parkingPricePerHour;
            this.chargingPricePerKWh = chargingPricePerKWh;
            this.verifyCode = verifyCode;
            this.isCanceled = isCanceled;
        }

        public Booking(Uint256 id, Utf8String bookerId, Utf8String parkingSpaceId, Utf8String bookingStart, Utf8String bookingEnd, Utf8String parkingPricePerHour, Utf8String chargingPricePerKWh, Uint256 verifyCode, Bool isCanceled) {
            super(id, bookerId, parkingSpaceId, bookingStart, bookingEnd, parkingPricePerHour, chargingPricePerKWh, verifyCode, isCanceled);
            this.id = id.getValue();
            this.bookerId = bookerId.getValue();
            this.parkingSpaceId = parkingSpaceId.getValue();
            this.bookingStart = bookingStart.getValue();
            this.bookingEnd = bookingEnd.getValue();
            this.parkingPricePerHour = parkingPricePerHour.getValue();
            this.chargingPricePerKWh = chargingPricePerKWh.getValue();
            this.verifyCode = verifyCode.getValue();
            this.isCanceled = isCanceled.getValue();
        }
    }
}
