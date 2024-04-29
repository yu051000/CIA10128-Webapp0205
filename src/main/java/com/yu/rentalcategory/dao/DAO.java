//package com.yu.rentalcategory.dao;
//
//import com.yu.rentalcategory.model.RentalCategory;
//
//import java.util.*;
//import java.sql.*;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//public class DAO implements RentalCategoryDAO_interface {
//
//    // 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
//    private static DataSource ds = null;
//    static {
//        try {
//            Context ctx = new InitialContext();
//            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/FalleloveDB");
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //新增
//    private static final String INSERT_STMT =
//            "INSERT INTO RentalCategory(rCatName, rStockQty, rRentedQty, rDesPrice) VALUES(?, ?, ?, ?)";
//    //修改
//    private static final String UPDATE =
//            "UPDATE RentalCategory SET rCatName=?, rStockQty=?, rRentedQty=?, rDesPrice=? WHERE rCatNo=?";
//
//    //單筆查詢
//    private static final String GET_ONE_STMT =
//            "SELECT rCatNo, rCatName, rStockQty, rRentedQty, rDesPrice FROM RentalCategory WHERE rCatNo=?";
//
//    //查詢全部
//    private static final String GET_ALL_STMT =
//            "SELECT rCatNo, rCatName, rStockQty, rRentedQty, rDesPrice FROM RentalCategory ORDER BY rCatNo";
//
//    //刪除 (目前是用sql級聯版。Hibernate有自己處理的方式，若用Hibernate，sql要換回一般的)
//    private static final String DELETE =
//            "DELETE FROM RentalCategory WHERE rCatNo= ?";
////        private static final String GET_Emps_ByDeptno_STMT = "SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 where deptno = ? order by empno";
////
////        private static final String DELETE_EMPs = "DELETE FROM emp2 where deptno = ?";
////        private static final String DELETE_DEPT = "DELETE FROM dept2 where deptno = ?";
//
//    @Override
//    public void insert(RentalCategory RentalCategory) {
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            con = ds.getConnection();
//            pstmt = con.prepareStatement(INSERT_STMT);
//
//            pstmt.setString(1, RentalCategory.getrCatName());
//            pstmt.setInt(2, RentalCategory.getrStockQty());
//            pstmt.setInt(3, RentalCategory.getrRentedQty());
//            pstmt.setBigDecimal(4, RentalCategory.getrDesPrice());
//
//            pstmt.executeUpdate(); //更新DB
//
//            // Handle any SQL errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//
//    }
//
//    @Override
//    public void update(RentalCategory RentalCategory) {
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//
//            con = ds.getConnection();
//            pstmt = con.prepareStatement(UPDATE);
//
//            pstmt.setString(1, RentalCategory.getrCatName());
//            pstmt.setInt(2, RentalCategory.getrStockQty());
//            pstmt.setInt(3, RentalCategory.getrRentedQty());
//            pstmt.setBigDecimal(4, RentalCategory.getrDesPrice());
//            pstmt.setInt(5, RentalCategory.getrCatNo());
//
//            pstmt.executeUpdate(); //更新DB
//
//            // Handle any driver errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//    }
//
//    @Override
//    public void delete(Integer rCatNo) {
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//
//        try {
//
//            con = ds.getConnection();
//            pstmt = con.prepareStatement(DELETE);
//
//            pstmt.setInt(1, rCatNo);
//
//            pstmt.executeUpdate(); //更新DB
//
//            // Handle any driver errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//
//    }
//
//    @Override
//    public RentalCategory findByPrimaryKey(Integer rCatNo) {
//
//        RentalCategory RentalCategory = null;
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            con = ds.getConnection();
//            pstmt = con.prepareStatement(GET_ONE_STMT);
//
//            pstmt.setInt(1, rCatNo);
//
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                // RentalCategory 也稱為 Domain objects
//                RentalCategory = new RentalCategory();
//                RentalCategory.setrCatNo(rs.getInt("rCatNo"));
//                RentalCategory.setrCatName(rs.getString("rCatName"));
//                RentalCategory.setrStockQty(rs.getInt("rStockQty"));
//                RentalCategory.setrRentedQty(rs.getInt("rRentedQty"));
//                RentalCategory.setrDesPrice(rs.getBigDecimal("rDesPrice"));
//            }
//
//            // Handle any driver errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//        return RentalCategory;
//    }
//
//    @Override
//    public List<RentalCategory> getAll() {
//        List<RentalCategory> list = new ArrayList<RentalCategory>();
//        RentalCategory RentalCategory = null;
//
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//
//            con = ds.getConnection();
//            pstmt = con.prepareStatement(GET_ALL_STMT);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                // empVO 也稱為 Domain objects
//                RentalCategory = new RentalCategory();
//                RentalCategory.setrCatNo(rs.getInt("rCatNo"));
//                RentalCategory.setrCatName(rs.getString("rCatName"));
//                RentalCategory.setrStockQty(rs.getInt("rStockQty"));
//                RentalCategory.setrRentedQty(rs.getInt("rRentedQty"));
//                RentalCategory.setrDesPrice(rs.getBigDecimal("rDesPrice"));
//                list.add(RentalCategory); // Store the row in the list
//            }
//
//
//            // Handle any driver errors
//        } catch (SQLException se) {
//            throw new RuntimeException("A database error occured. "
//                    + se.getMessage());
//            // Clean up JDBC resources
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//                } catch (SQLException se) {
//                    se.printStackTrace(System.err);
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace(System.err);
//                }
//            }
//        }
//        return list;
//    }
//}