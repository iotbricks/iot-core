# IoT Core Services [![Build status](https://api.travis-ci.org/iot-core/iot-core.svg)](https://travis-ci.org/iot-core/iot-core) 

## AMQP API

### Common data structures    

    Device
    JSON {"deviceId": string, "created": string, "updated": string, "properties": map}

### Operations

    Device create operation
    Description: Creates new instance of a device in a device registry. If "deviceId" is not specified, it will be 
                 autogenerated on the server side. 
    Address: device
    Subject: create
    Payload: Device
    Return value: ID of a device.
    
    Device update operation
    Description: Updates instance of a device in a device registry. "deviceId" field is used to identifiy target device.
    Address: device
    Subject: update
    Payload: Device

    Device save operation
    Description: Creates new device instance or updates an existing one. "deviceId" field is used to identifiy target 
                 device.  If "deviceId" is not specified, it will be autogenerated on the server side.
    Address: device
    Subject: save
    Payload: Device
    Return value: ID of a device.

    Find device by ID operation
    Description: Finds device in a device registry by "deviceId" field.
    Address: device
    Subject: findById
    Payload: deviceId string
    Return value: Device