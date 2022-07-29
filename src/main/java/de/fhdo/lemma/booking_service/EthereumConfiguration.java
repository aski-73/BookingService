package de.fhdo.lemma.booking_service;

import java.io.IOException;
import java.math.BigInteger;

import de.fhdo.lemma.booking_service.gen.EthereumConfigurationGen;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

public class EthereumConfiguration implements EthereumConfigurationGen {
    private static final String PRIVATE_KEY = "0041fadaf6f8caa9d392921eee410004948477a65db9b25babf1f56f6af1744d";
    private static final String HOST_NAME = "localhost";
    private static final int PORT = 8545;
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(8000000L);
    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    @Override
    public Web3j buildConnection() {
        return Web3j.build(new HttpService("http://" + HOST_NAME + ":" + PORT));
    }

    @Override
    public Web3ClientVersion getWeb3ClientVersion(Web3j web3j) {
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
            System.out.println("Web3 client version: " + web3ClientVersion.
                    getWeb3ClientVersion());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println(ioe.getMessage());
        }
        return web3ClientVersion;
    }

    @Override
    public Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

    @Override
    public TransactionManager getRawTransactionManager(Web3j web3j, Credentials
            credentials) {
        return new RawTransactionManager(web3j, credentials);
    }

    @Override
    public ContractGasProvider getContractGasProvider() {
        return new ContractGasProvider() {
            @Override
            public BigInteger getGasPrice(String s) {
                return GAS_PRICE;
            }

            @Override
            @Deprecated
            public BigInteger getGasPrice() {
                return GAS_PRICE;
            }

            @Override
            public BigInteger getGasLimit(String s) {
                return GAS_LIMIT;
            }

            @Override
            @Deprecated
            public BigInteger getGasLimit() {
                return GAS_LIMIT;
            }
        };
    }

    @Override
    public String deploySmartContract(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        try {
            String contractAddress = ChargeBookingManagementNormal
                    .deploy(web3j, transactionManager, contractGasProvider)
                    .send()
                    .getContractAddress();
            return contractAddress;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public ChargeBookingManagementNormal loadSmartContract(String contractAddress, Web3j web3j,
                                                           TransactionManager transactionManager,
                                                           ContractGasProvider contractGasProvider) {
        return ChargeBookingManagementNormal.load(contractAddress, web3j, transactionManager,
                contractGasProvider);
    }
}
