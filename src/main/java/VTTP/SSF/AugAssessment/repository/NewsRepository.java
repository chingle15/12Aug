package VTTP.SSF.AugAssessment.repository;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonArray;


@Repository
public class NewsRepository {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    public void save(JsonArray newsId, String payload) {
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
    }

    public String get(String userid) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        return valueOps.get(userid);
    }
}
