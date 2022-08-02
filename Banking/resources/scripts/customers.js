class Customer {
    constructor(id, fullName, phoneNumber, email, address, balance) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.balance = balance;
    }
}

var customers = [];

const customerData = "customerData";

function init() {
    if (getLocalStorage(customerData) == null) {
        customers = [
            new Customer(1, "Minh Bui", "0912345678", "minh@gmail.com", "Hue", 3000000),
            
        ]
        setLocalStorage(customerData, customers);
        return;
    }
    customers = getLocalStorage(customerData);
}

function setLocalStorage(key, data) {
    localStorage.setItem(key, JSON.stringify(data))
}

function getLocalStorage(key) {
    return JSON.parse(localStorage.getItem(key))
}

function renderCustomers() {
    let htmls = customers.map(function (customer) {
        return `
        <tr>
            <td>
                <input type="checkbox">
            </td>
            <td class="align-center">${customer.id}</td>
            <td>${customer.fullName}</td>
            <td>${customer.email}</td>
            <td>${customer.phoneNumber}</td>
            <td>${customer.address}</td>
            <td class="align-right">${customer.balance}</td>
            <td id = "action">
                <a title="Edit" href="./services/updateInfo.html" data-toggle="tooltip" class="btn btn-outline-primary">
                    <i class="fa-solid fa-user-pen"></i>
                </a>
                <a title="Deposit" href="./services/deposit.html" data-toggle="tooltip" class="btn btn-outline-secondary">
                    <i class="fa-solid fa-circle-plus"></i>
                </a>
                <a title="Withdraw" href="./services/withdraw.html" data-toggle="tooltip" class="btn btn-outline-success">
                    <i class="fa-solid fa-circle-minus"></i>
                </a>
                <a title="Transfer" href="./services/transfer.html" data-toggle="tooltip" class="btn btn-outline-warning">
                    <i class="fa-solid fa-arrow-right-arrow-left"></i>
                </a>
                <a title="Remove" href="./services/remove.html" data-toggle="tooltip" class="btn btn-outline-danger">
                    <i class="fa-solid fa-user-xmark"></i>
                </a>
            </td>
        </tr>`
    })
    document.querySelector("#tbCustomers>tbody").innerHTML = htmls.join("")
}

(function () {
    init();
    renderCustomers();
})()
