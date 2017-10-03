package org.iotbricks.service.device.registry.mongo.spring;

import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import org.iotbricks.service.device.registry.mongo.MongoDeviceRegistryService;
import org.iotbricks.service.device.registry.api.DeviceRegistryService;
import org.iotbricks.service.device.registry.spi.DeviceSchemaValidator;
import org.iotbricks.service.device.registry.spi.spring.DeviceRegistryServiceSpiConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DeviceRegistryServiceSpiConfiguration.class)
public class DeviceRegistryConfiguration {

    @Bean DeviceRegistryService deviceRegistry(IMongodConfig mongodConfig, DeviceSchemaValidator deviceSchemaValidator) {
        MongoClient mongoClient = new MongoClient("localhost", mongodConfig.net().getPort());
        return new MongoDeviceRegistryService(mongoClient, deviceSchemaValidator);
    }

}