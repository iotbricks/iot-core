package iotcore.service.device;

public class MockDeviceSchemaValidator implements DeviceSchemaValidator {

    @Override public void validate(Device device) {
        if("geoDeviceSchema".equals(device.getType())) {
            if(!device.getProperties().containsKey("lat") || !device.getProperties().containsKey("lng")) {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }
    }

}