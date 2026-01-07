package hugo.ai.controller;

import hugo.ai.entity.DataTest;
import hugo.ai.service.DataTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/datatest")
public class DataTestController {

    @Autowired
    private DataTestService dataTestService;

    @GetMapping("/{id}")
    public ResponseEntity<DataTest> getDataTestById(@PathVariable String id) {
        DataTest dataTest = dataTestService.findById(id);
        if (dataTest != null) {
            return ResponseEntity.ok(dataTest);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<DataTest>> getAllDataTests() {
        List<DataTest> dataTests = dataTestService.findAll();
        return ResponseEntity.ok(dataTests);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createDataTest(@RequestBody DataTest dataTest) {
        int result = dataTestService.save(dataTest);
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("success", true);
            response.put("message", "数据创建成功");
            response.put("data", dataTest);
            return ResponseEntity.ok(response);
        }
        response.put("success", false);
        response.put("message", "数据创建失败");
        return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateDataTest(@PathVariable String id, @RequestBody DataTest dataTest) {
        dataTest.setId(id);
        int result = dataTestService.update(dataTest);
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("success", true);
            response.put("message", "数据更新成功");
            response.put("data", dataTest);
            return ResponseEntity.ok(response);
        }
        response.put("success", false);
        response.put("message", "数据更新失败");
        return ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDataTest(@PathVariable String id) {
        int result = dataTestService.deleteById(id);
        Map<String, Object> response = new HashMap<>();
        if (result > 0) {
            response.put("success", true);
            response.put("message", "数据删除成功");
            return ResponseEntity.ok(response);
        }
        response.put("success", false);
        response.put("message", "数据删除失败");
        return ResponseEntity.badRequest().body(response);
    }
}
