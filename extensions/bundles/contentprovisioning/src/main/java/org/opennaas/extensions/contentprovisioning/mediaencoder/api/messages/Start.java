package org.opennaas.extensions.contentprovisioning.mediaencoder.api.messages;

/*
 * #%L
 * OpenNaaS :: Content Provisioning
 * %%
 * Copyright (C) 2007 - 2014 Fundació Privada i2CAT, Internet i Innovació a Catalunya
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import javax.xml.bind.annotation.XmlRootElement;

import org.opennaas.extensions.contentprovisioning.mediaencoder.api.IMediaEncoder;

/**
 * Start empty message to be used in {@link IMediaEncoder}
 * 
 * @author Julio Carlos Barrera
 * 
 */
@XmlRootElement(name = "start")
public class Start {

}