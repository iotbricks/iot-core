/**
 * Copyright (c) 2017 Red Hat Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Red Hat Inc - initial creation
 */

package iot.core.hono.device.registry;

import org.eclipse.hono.config.SignatureSupportingConfigProperties;
import org.eclipse.hono.deviceregistry.SignatureSupporting;
import org.iotbricks.client.device.registry.Client;
import org.iotbricks.client.device.registry.LocalClient;
import org.iotbricks.service.device.registry.api.DeviceRegistryService;
import org.springframework.beans.factory.annotation.Autowired;

import io.vertx.core.Vertx;

public final class CoreLocalBasedRegistrationConfigProperties implements SignatureSupporting, ClientBuilding {

    private final SignatureSupportingConfigProperties registrationAssertionProperties = new SignatureSupportingConfigProperties();

    @Override
    public SignatureSupportingConfigProperties getSigning() {
        return this.registrationAssertionProperties;
    }

    private DeviceRegistryService registry;

    @Autowired
    public void setRegistry(final DeviceRegistryService registry) {
        this.registry = registry;
    }

    @Override
    public Client createClient(final Vertx vertx) {
        return new LocalClient(this.registry);
    }

}
