package test.dao;

import com.hxuanyu.commodity.beans.Operation;
import com.hxuanyu.commodity.dao.OperationDao;
import com.hxuanyu.commodity.dao.impl.OperationDaoImpl;
import com.hxuanyu.commodity.enums.OperationType;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 操作数据库相关测试类
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Ignore
public class TestOperationDao {

    OperationDao operationDao = new OperationDaoImpl();

    @Test
    public void testGetAllOperation() {
        List<Operation> operationList = operationDao.getAllOperation();
        for (Operation operation : operationList) {
            System.out.println(operation);
        }
    }

    @Test
    public void testGetOperation() {
        Operation operation = operationDao.getOperationById(1);
        System.out.println(operation);
    }

    @Test
    public void testAddOperation() {
        int result = operationDao.addOperation(new Operation(
                1,
                2,
                new Date(System.currentTimeMillis()),
                OperationType.ADD_COMMODITY.value(),
                "test",
                "test"
        ));
        System.out.println(result);
    }

}
