/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.ejb3.deployment.processors.annotation;

import org.jboss.as.ee.metadata.ClassAnnotationInformationFactory;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.AnnotationValue;

import javax.ejb.AccessTimeout;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * Processes the {@link javax.ejb.AccessTimeout} annotation on a session bean
 *
 * @author Stuart Douglas
 */
public class AccessTimeoutAnnotationInformationFactory extends ClassAnnotationInformationFactory<AccessTimeout, AccessTimeout> {

    protected AccessTimeoutAnnotationInformationFactory() {
        super(AccessTimeout.class, null);
    }

    @Override
    protected AccessTimeout fromAnnotation(final AnnotationInstance annotationInstance) {
        final long timeout = annotationInstance.value().asLong();
        AnnotationValue unitAnnVal = annotationInstance.value("unit");
        final TimeUnit unit = unitAnnVal != null ? TimeUnit.valueOf(unitAnnVal.asEnum()) : TimeUnit.MILLISECONDS;
        return new AccessTimeout() {
            @Override
            public long value() {
                return timeout;
            }

            @Override
            public TimeUnit unit() {
                return unit;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return AccessTimeout.class;
            }
        };
    }
}
