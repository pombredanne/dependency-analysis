/**
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.pnc.rest.notifications;

import org.jboss.pnc.spi.events.BuildSetStatusChangedEvent;
import org.jboss.pnc.spi.events.BuildStatusChangedEvent;
import org.jboss.pnc.spi.notifications.model.*;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultNotificationFactory implements NotificationFactory {

    public DefaultNotificationFactory() {
    }

    @Override
    public Notification createNotification(BuildStatusChangedEvent event) {
        BuildChangedPayload payload = new BuildChangedPayload(event.getBuildTaskId(), event.getNewStatus(), event.getBuildConfigurationId(), event.getUserId());

        return new Notification(EventType.BUILD_STATUS_CHANGED, null, payload);
    }

    @Override
    public Notification createNotification(BuildSetStatusChangedEvent event) {
        BuildSetChangedPayload payload = new BuildSetChangedPayload(event.getBuildSetTaskId(), event.getNewStatus(), event.getBuildSetConfigurationId(), event.getUserId());

        return new Notification(EventType.BUILD_SET_STATUS_CHANGED, null, payload);
    }

}