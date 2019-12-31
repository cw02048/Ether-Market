/*
 * %W% %E% Zain-Ul-Abedin
 *
 * Copyright (c) 2017-2018 Miranz Technology. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Miranz
 * technology. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with Miranz.
 *
 */

package android.wallet.com.wallet.web3J;

import android.content.SharedPreferences;
import android.os.Environment;
import android.wallet.com.wallet.MainActivity;
import android.widget.Toast;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionTimeoutException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static android.content.Context.MODE_PRIVATE;


/**
 * This class is written for basic functions of Ethereum and web3j integration
 * Because it's handling all the basic function of web3j so that's why we named
 * it as a web3Handler.
 */

public class Web3jHandler {

    /** String variable 'network' is used for selecting which network you want to use */
    private static Web3j web3;
    /** Web3j variable 'web3' is used to implement all the functions, exist in Web3j Library */
    private static Credentials credentials;
    /** Credentials variable 'credentials' is used to implement all the functions, exist in Credentials Library */
    private static TransactionReceipt transactionReceipt;

    /**
     * web3Connection function is used to create the connection with the end-client node. // I uses Infura API.
     * @return condition
     */
    public static boolean web3Connection() throws IOException {
        web3 = Web3jFactory.build(new HttpService("https://kovan.infura.io/v3/60a7253d4849469f8f3beb166e566fd3"));

        return  web3 != null;
    }

    /**
     * loadCredentials function is used to load the UTC-JSON file from a particular path.
     * @param password  is used to access your UTC-JSON file.
     * @throws IOException
     * @throws CipherException
     */
    public static void loadCredentials(String password, String fileName) throws IOException, CipherException {
        credentials = WalletUtils.loadCredentials(password, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + fileName);
    }

    /**
     * transaction function is used to send funds from your address to another Ethereum address.
     * @param address   is a TO address or a address where you want to transfer funds.
     * @param ethBalance   is a amount you want to send.
     * @throws TransactionTimeoutException
     * @throws IOException
     * @throws InterruptedException
     * @return
     */
    public static TransactionReceipt transaction(String address, double ethBalance) throws InterruptedException, IOException, TransactionTimeoutException {
        return transactionReceipt = Transfer.sendFunds( web3, credentials, address, BigDecimal.valueOf(ethBalance), Convert.Unit.ETHER);
    }


    /**
     * getBalance function is used to get Balance and it returns the BigInteger value.
     * @throws InterruptedException
     * @throws ExecutionException
     * @return
     */
    public static BigInteger getBalance(){
        Future<EthGetBalance> ethGetBalanceFuture = web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).sendAsync();
        try {
            return ethGetBalanceFuture.get().getBalance();
        }catch (Exception e){
            return BigInteger.ONE;
        }
    }

    /**
     * This function is returning wallet address from credentials
     * @return address in String
     * */
    public static String getWalletAddress(){
        return credentials.getAddress();
    }

    public static String address(String name) throws ExecutionException, InterruptedException{

        Payment payment = Payment.load("0xe8Ea0d2133317dC85112a80FC5AC8d6C1B77146C", web3, credentials, BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4300000));
        Future<Address> value1 = payment.getSellerAddress(new Utf8String(name));
        Address price2 = value1.get();
        String result = price2.toString();

        return result;
    }

    public static String stock(String name) throws ExecutionException, InterruptedException{

        Payment payment = Payment.load("0xe8Ea0d2133317dC85112a80FC5AC8d6C1B77146C", web3, credentials, BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4300000));
        Future<Uint256> value1 = payment.getStock(new Utf8String(name));
        Uint256 value2 = value1.get();
        BigInteger result = value2.getValue();

        return result.toString();
    }

    public static String price(String name) throws ExecutionException, InterruptedException{

        Payment payment = Payment.load("0xe8Ea0d2133317dC85112a80FC5AC8d6C1B77146C", web3, credentials, BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4300000));
        Future<Uint256> value1 = payment.getPrice(new Utf8String(name));
        Uint256 value2 = value1.get();
        BigInteger result = value2.getValue();

        return result.toString();
    }

    public static String productCount() throws ExecutionException, InterruptedException{

        Payment payment = Payment.load("0xe8Ea0d2133317dC85112a80FC5AC8d6C1B77146C", web3, credentials, BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4300000));
        Future<Uint256> value1 = payment.getProductCount();
        Uint256 value2 = value1.get();
        BigInteger result = value2.getValue();

        return result.toString();
    }

    public static String productName(int index) throws ExecutionException, InterruptedException{

        Payment payment = Payment.load("0xe8Ea0d2133317dC85112a80FC5AC8d6C1B77146C", web3, credentials, BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4300000));
        Future<Utf8String> value1 = payment.getProductList(new Uint256(index));
        Utf8String value2 = value1.get();
        String result = value2.getValue();

        return result;
    }

    public static void registration(String name, int price, int stock) {
        Payment payment = Payment.load("0xe8Ea0d2133317dC85112a80FC5AC8d6C1B77146C", web3, credentials, BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4300000));
        payment.registration(new Utf8String(name), new Uint256(price), new Uint256(stock));
    }

    public static void buy(String name, int stock) {
        Payment payment = Payment.load("0xe8Ea0d2133317dC85112a80FC5AC8d6C1B77146C", web3, credentials, BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(4300000));
        payment.buy(new Utf8String(name), new Uint256(stock));
    }
}