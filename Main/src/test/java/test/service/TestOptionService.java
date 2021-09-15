package test.service;

import com.hxuanyu.commodity.beans.Operation;
import com.hxuanyu.commodity.dao.impl.OperationDaoImpl;
import com.hxuanyu.commodity.enums.OperationType;
import com.hxuanyu.commodity.service.OperationService;
import com.hxuanyu.commodity.service.impl.OperationServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * 操作服务测试类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class TestOptionService {
    OperationService operationService = new OperationServiceImpl(new OperationDaoImpl());

    @Test
    public void testGetAllOperation() {
        List<Operation> operationList = operationService.getAllOperation();
        for (Operation operation : operationList) {
            System.out.println(operation);
        }
    }

    @Test
    public void testGetOperationById() {
        System.out.println(operationService.getOperationById(1));
    }

    @Test
    public void testAddOperation() {
        System.out.println(operationService.addOperation(new Operation()));
        System.out.println(operationService.addOperation(new Operation(
                1,
                1,
                OperationType.ADD_COMMODITY
        )));
    }
}
