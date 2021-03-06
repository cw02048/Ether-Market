package android.wallet.com.wallet.web3J;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
    private static final String BINARY = "60606040526004805460ff19166001179055341561001c57600080fd5b6107d78061002b6000396000f3006060604052600436106100985763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630ca5c504811461009d5780631f32b9c8146101365780631fa195961461015b5780634a348da91461017d578063524f3889146101a25780638fbf1370146101c05780639a37dea4146101fa578063ca7a7b7a14610210578063e554f6721461022e575b600080fd5b34156100a857600080fd5b6100bf602460048035828101929101359035610250565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100fb5780820151838201526020016100e3565b50505050905090810190601f1680156101285780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561014157600080fd5b6100bf6024600480358281019291013590356044356102c3565b341561016657600080fd5b6100bf60246004803582810192910135903561042b565b341561018857600080fd5b6101906104e5565b60405190815260200160405180910390f35b34156101ad57600080fd5b61019060048035602481019101356104ec565b34156101cb57600080fd5b6101de600480356024810191013561052e565b604051600160a060020a03909116815260200160405180910390f35b341561020557600080fd5b6100bf600435610566565b341561021b57600080fd5b6101906004803560248101910135610621565b341561023957600080fd5b6100bf602460048035828101929101359035610651565b610258610701565b816001858560405180838380828437820191505092505050908152602001604051908190039020805491909103905560408051908101604052600c81527f62757920636f6d706c65746500000000000000000000000000000000000000006020820152949350505050565b6102cb610701565b600185856040518083838082843782019150509250505090815260200160405190819003902054156102fc57600080fd5b336000868660405180838380828437820191505092505050908152602001604051908190039020805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905581600186866040518083838082843782019150509250505090815260200160405190819003902055670de0b6b3a7640000830260028686604051808383808284378201915050925050509081526020016040519081900390205560045460ff161515600114156103c8576004805460ff1916905560006005555b60055460009081526003602052604090206103e4908686610713565b5060058054600101905560408051908101604052601581527f726567697374726174696f6e20636f6d706c6574650000000000000000000000602082015295945050505050565b610433610701565b33600160a060020a0316600085856040518083838082843782019150509250505090815260200160405190819003902054600160a060020a03161461047757600080fd5b81670de0b6b3a76400000260028585604051808383808284378201915050925050509081526020016040519081900390205560408051908101604052601581527f7072696365206368616e676520636f6d706c65746500000000000000000000006020820152949350505050565b6005545b90565b6000670de0b6b3a7640000600284846040518083838082843782019150509250505090815260200160405180910390205481151561052657fe5b049392505050565b60008083836040518083838082843782019150509250505090815260200160405190819003902054600160a060020a03169392505050565b61056e610701565b600360008381526020019081526020016000208054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106155780601f106105ea57610100808354040283529160200191610615565b820191906000526020600020905b8154815290600101906020018083116105f857829003601f168201915b50505050509050919050565b60006001838360405180838380828437820191505092505050908152602001604051809103902054905092915050565b610659610701565b33600160a060020a0316600085856040518083838082843782019150509250505090815260200160405190819003902054600160a060020a03161461069d57600080fd5b8160018585604051808383808284378201915050925050509081526020016040519081900390205560408051908101604052601581527f73746f636b206368616e676520636f6d706c65746500000000000000000000006020820152949350505050565b60206040519081016040526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106107545782800160ff19823516178555610781565b82800160010185558215610781579182015b82811115610781578235825591602001919060010190610766565b5061078d929150610791565b5090565b6104e991905b8082111561078d57600081556001016107975600a165627a7a723058203239908373d956b590ce3773058279ea653651b547b66c8442cfe3d5e6b493680029";

    private Payment(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private Payment(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> buy(Utf8String name, Uint256 stock) {
        Function function = new Function("buy", Arrays.<Type>asList(name, stock), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> registration(Utf8String name, Uint256 price, Uint256 stock) {
        Function function = new Function("registration", Arrays.<Type>asList(name, price, stock), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> changePrice(Utf8String name, Uint256 price) {
        Function function = new Function("changePrice", Arrays.<Type>asList(name, price), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getProductCount() {
        Function function = new Function("getProductCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getPrice(Utf8String name) {
        Function function = new Function("getPrice", 
                Arrays.<Type>asList(name), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Address> getSellerAddress(Utf8String name) {
        Function function = new Function("getSellerAddress", 
                Arrays.<Type>asList(name), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> getProductList(Uint256 index) {
        Function function = new Function("getProductList", 
                Arrays.<Type>asList(index), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
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
