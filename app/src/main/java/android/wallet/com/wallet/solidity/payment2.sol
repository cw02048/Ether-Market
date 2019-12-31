pragma solidity ^0.4.19;

contract payment {
    mapping (string => address) private product_seller;
    mapping (string => uint256) private product_stock;
    mapping (string => uint256) private product_price;
    mapping (uint256 => string) private product_list;
    bool first_registration = true;
    uint256 product_number;

    function registration(string name, uint256 price, uint256 stock) external returns (string) {
        require(product_stock[name] == 0);
        product_seller[name] = msg.sender;
        product_stock[name] = stock;
        product_price[name] = price * 10**18;

        if (first_registration == true){
            first_registration = false;
            product_number = 0;
        }

        product_list[product_number] = name;

        product_number += 1;

        return "registration complete";
    }

    function buy(string name, uint256 stock) external returns (string) {
        // require(stock >= 1);
        // require(product_price[name] == price * 10**18);
        // require((product_price[name]) * stock == msg.value);

        product_stock[name] -= stock;
        // product_seller[name].transfer(product_price[name] * stock);

        return "buy complete";
    }

    function changePrice(string name, uint256 price) external returns (string) {
        require(product_seller[name] == msg.sender);
        product_price[name] = price * 10**18;

        return "price change complete";
    }

      function changeStock(string name, uint256 stock) external returns (string) {
        require(product_seller[name] == msg.sender);
        product_stock[name] = stock;

        return "stock change complete";
    }

    function getStock(string name) external view returns (uint256) {
        return product_stock[name];
    }

    function getPrice(string name) external view returns (uint256) {
        return product_price[name] / 10**18;
    }

    function getProductCount() external view returns (uint256) {
        return product_number;
    }

    function getProductList(uint256 index) external view returns (string) {
        return product_list[index];
    }

    function getSellerAddress(string name) external view returns (address) {
        return product_seller[name];
    }
}