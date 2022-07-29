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

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class ChargeBookingManagementNormal extends Contract {
    public static final String BINARY = "";
    public static final String FUNC_CANCELBOOKING = "cancelBooking";
    public static final String FUNC_CREATEBOOKING = "createBooking";

    public static final String FUNC_READBOOKING = "readBooking";

    public static final String FUNC_UPDATEBOOKING = "updateBooking";

    @Deprecated
    protected ChargeBookingManagementNormal(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ChargeBookingManagementNormal(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ChargeBookingManagementNormal(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ChargeBookingManagementNormal(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelBooking(BigInteger id) {
        final Function function = new Function(
                FUNC_CANCELBOOKING,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createBooking(Booking b) {
        final Function function = new Function(
                FUNC_CREATEBOOKING,
                Arrays.<Type>asList(b),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> readBooking(BigInteger id) {
        final Function function = new Function(
                FUNC_READBOOKING,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateBooking(BigInteger id, String bookingStart, String bookingEnd, BigInteger verifyCode) {
        final Function function = new Function(
                FUNC_UPDATEBOOKING,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id),
                        new org.web3j.abi.datatypes.Utf8String(bookingStart),
                        new org.web3j.abi.datatypes.Utf8String(bookingEnd),
                        new org.web3j.abi.datatypes.generated.Uint256(verifyCode)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ChargeBookingManagementNormal load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargeBookingManagementNormal(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ChargeBookingManagementNormal load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChargeBookingManagementNormal(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ChargeBookingManagementNormal load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ChargeBookingManagementNormal(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ChargeBookingManagementNormal load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ChargeBookingManagementNormal(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ChargeBookingManagementNormal> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChargeBookingManagementNormal.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ChargeBookingManagementNormal> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChargeBookingManagementNormal.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ChargeBookingManagementNormal> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChargeBookingManagementNormal.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ChargeBookingManagementNormal> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChargeBookingManagementNormal.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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
            super(new org.web3j.abi.datatypes.generated.Uint256(id), new org.web3j.abi.datatypes.Utf8String(bookerId), new org.web3j.abi.datatypes.Utf8String(parkingSpaceId), new org.web3j.abi.datatypes.Utf8String(bookingStart), new org.web3j.abi.datatypes.Utf8String(bookingEnd), new org.web3j.abi.datatypes.Utf8String(parkingPricePerHour), new org.web3j.abi.datatypes.Utf8String(chargingPricePerKWh), new org.web3j.abi.datatypes.generated.Uint256(verifyCode), new org.web3j.abi.datatypes.Bool(isCanceled));
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
