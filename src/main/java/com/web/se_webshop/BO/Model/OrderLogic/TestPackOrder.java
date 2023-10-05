package com.web.se_webshop.BO.Model.OrderLogic;

import com.web.se_webshop.DB.BDObjects.DbOrder;

import java.sql.SQLException;

public class TestPackOrder {

    public static void main(String[] args) throws SQLException {
        DbOrder.packOrderDB("1");
    }
}
