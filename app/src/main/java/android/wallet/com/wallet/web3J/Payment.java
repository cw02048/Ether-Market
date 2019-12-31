package android.wallet.com.wallet.web3J;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.2.1.
 */
public final class Payment extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6106568061001e6000396000f3006060604052600436106100775763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631f32b9c8811461007c5780631fa1959614610118578063524f38891461013a5780639b0a5e671461016a578063ca7a7b7a14610184578063e554f672146101a2575b600080fd5b341561008757600080fd5b6100a16024600480358281019291013590356044356101c4565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100dd5780820151838201526020016100c5565b50505050905090810190601f16801561010a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561012357600080fd5b6100a16024600480358281019291013590356102e6565b341561014557600080fd5b61015860048035602481019101356103a0565b60405190815260200160405180910390f35b6100a16024600480358281019291013590356044356103e2565b341561018f57600080fd5b6101586004803560248101910135610538565b34156101ad57600080fd5b6100a1602460048035828101929101359035610568565b6101cc610618565b600185856040518083838082843782019150509250505090815260200160405190819003902054156101fd57600080fd5b336000868660405180838380828437820191505092505050908152602001604051908190039020805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905581600186866040518083838082843782019150509250505090815260200160405190819003902055670de0b6b3a7640000830260028686604051808383808284378201915050925050509081526020016040519081900390205560408051908101604052601581527f726567697374726174696f6e20636f6d706c6574650000000000000000000000602082015295945050505050565b6102ee610618565b33600160a060020a0316600085856040518083838082843782019150509250505090815260200160405190819003902054600160a060020a03161461033257600080fd5b81670de0b6b3a76400000260028585604051808383808284378201915050925050509081526020016040519081900390205560408051908101604052601581527f7072696365206368616e676520636f6d706c65746500000000000000000000006020820152949350505050565b6000670de0b6b3a764000060028484604051808383808284378201915050925050509081526020016040518091039020548115156103da57fe5b049392505050565b6103ea610618565b60018210156103f857600080fd5b82670de0b6b3a7640000026002868660405180838380828437820191505092505050908152602001604051908190039020541461043457600080fd5b828202670de0b6b3a764000002341461044c57600080fd5b8160018686604051808383808284378201915050925050509081526020016040519081900390208054919091039055600085856040518083838082843782019150509250505090815260200160405190819003902054600160a060020a03166108fc836002888860405180838380828437820191505092505050908152602001604051809103902054029081150290604051600060405180830381858888f1935050505015156104fb57600080fd5b60408051908101604052600c81527f62757920636f6d706c6574650000000000000000000000000000000000000000602082015295945050505050565b60006001838360405180838380828437820191505092505050908152602001604051809103902054905092915050565b610570610618565b33600160a060020a0316600085856040518083838082843782019150509250505090815260200160405190819003902054600160a060020a0316146105b457600080fd5b8160018585604051808383808284378201915050925050509081526020016040519081900390205560408051908101604052601581527f73746f636b206368616e676520636f6d706c65746500000000000000000000006020820152949350505050565b602060405190810160405260008152905600a165627a7a72305820175497f4fb43ba066a7509f4817ab8fe3b46391d16da093693af23d9e3b457f30029";

    private Payment(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private Payment(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> registration(Utf8String name, Uint256 price, Uint256 stock) {
        Function function = new Function("registration", Arrays.<Type>asList(name, price, stock), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> changePrice(Utf8String name, Uint256 price) {
        Function function = new Function("changePrice", Arrays.<Type>asList(name, price), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getPrice(Utf8String name) {
        Function function = new Function("getPrice", 
                Arrays.<Type>asList(name), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> buy(Utf8String name, Uint256 price, Uint256 stock) {
        Function function = new Function("buy", Arrays.<Type>asList(name, price, stock), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getStock(Utf8String name) {
        Function function = new Function("getStock", 
                Arrays.<Type>asList(name), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> changeStock(Utf8String name, Uint256 stock) {
        Function function = new Function("changeStock", Arrays.<Type>asList(name, stock), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<Payment> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Payment.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<Payment> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Payment.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Payment load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Payment(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Payment load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Payment(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
