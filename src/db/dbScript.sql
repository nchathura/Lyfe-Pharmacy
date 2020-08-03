CREATE DATABASE lyfePharmacy;

SHOW DATABASES;

USE lyfePharmacy;

CREATE TABLE Employee (
  empId varchar(10) not null,
  empName varchar(100) not null,
  empAddress varchar(100) not null,
  email varchar(100) not null,
  contactNo varchar(15),
  dateOfBirth date not null,
  joinedDate date not null,
  address varchar(100) not null,
  salary decimal(10,4),
  gender varchar(5),
  CONSTRAINT employee_primarykey PRIMARY KEY(empID)


);

DESC Employee;
CREATE TABLE Item(
    itemCode varchar(10) not null,
    description varchar(100) not null,
    category varchar(100) not null,
    manufacturer varchar(100) not null,
    productionDate date not null,
    expiryDate date not null,
    buyingPrice decimal(10,4) not null,
    sellingPrice decimal(10,4) not null,
    minimumStockLevel decimal(10,4) not null,
    qtyOnHand decimal(10,4) not null,
    unitPrice decimal(10,4) not null,
    CONSTRAINT item_primarykey PRIMARY KEY(itemCode)

);

drop table Item;

CREATE TABLE Company(
    companyId varchar(10) not null,
    companyName varchar(100) not null,
    entryDate date not null,
    companyPhoneNo varchar(15) not null,
    companyEmail varchar(100) not null,
    CONSTRAINT company_primarykey PRIMARY KEY(companyId)
);

CREATE TABLE Agent(
    agentId varchar(10) not null,
    companyId varchar(10) not null,
    entryDate date not null,
    agentPhoneNo varchar(15) not null,
    agentEmail varchar(100) not null,
    CONSTRAINT agent_primarykey PRIMARY KEY(agentId),
    CONSTRAINT agent_foreignkey FOREIGN KEY(companyId) REFERENCES company(companyId)
);

CREATE TABLE `Order`(
    orderId varchar(10) not null,
    empId varchar(10) not null,
    orderDate date not null,
    CONSTRAINT order_primarykey PRIMARY KEY(orderId),
    CONSTRAINT order_foreignkey FOREIGN KEY(empId) REFERENCES employee(empId)
);

CREATE TABLE CompanyItem(
    ItemCode varchar(10) not null,
    CompanyId varchar(10) not null,
    CONSTRAINT companyItem_primarykey PRIMARY KEY(ItemCode,CompanyId),
    CONSTRAINT companyItem_foreignkey1 FOREIGN KEY(ItemCode) REFERENCES item(itemCode),
    CONSTRAINT companyItem_foreignkey2 FOREIGN KEY(CompanyId) REFERENCES company(companyId)

);

CREATE TABLE orderDetail(
    orderId varchar(10) not null,
    itemCode varchar(10) not null,
    qty int not null,
    unitPrice decimal(10,4) not null,
    CONSTRAINT orderDetail_primarykey PRIMARY KEY(orderId,itemCode),
    CONSTRAINT orderDetail_foreignkey1  FOREIGN KEY(orderId) REFERENCES `order`(orderId),
    CONSTRAINT orderDetail_foreignkey2  FOREIGN KEY(itemCode) REFERENCES item(itemCode)


);

