/*******************************************************************************
 * Copyright (c) 2020 Northrop Grumman Systems Corporation.
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
 *******************************************************************************/
package com.zeligsoft.domain.zml.api.ZML_Component.impl;

import com.zeligsoft.base.zdl.staticapi.util.ZDLFactoryRegistry;
import com.zeligsoft.base.zdl.staticapi.internal.core.ZObjectImpl;

import com.zeligsoft.domain.zml.api.ZML_Component.AssemblyConnector;

import com.zeligsoft.domain.zml.api.ZML_Component.Port;
import com.zeligsoft.domain.zml.api.ZML_Component.ConnectorEnd;

import com.zeligsoft.base.zdl.util.ZDLUtil;

public class AssemblyConnectorImplementation extends ZObjectImpl implements
		AssemblyConnector {
	protected java.util.List<ConnectorEnd> _end;
	protected java.util.List<Port> _portEnd;

	public AssemblyConnectorImplementation(org.eclipse.emf.ecore.EObject element) {
		super(element);
	}

	@Override
	public java.util.List<ConnectorEnd> getEnd() {
		if (_end == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::AssemblyConnector", "end");
			_end = new java.util.ArrayList<ConnectorEnd>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					ConnectorEnd nextWrapper = ZDLFactoryRegistry.INSTANCE
							.create((org.eclipse.emf.ecore.EObject) next,
									ConnectorEnd.class);
					_end.add(nextWrapper);
				}
			}
		}
		return _end;
	}

	@Override
	public void addEnd(ConnectorEnd val) {
		// make sure the end list is created
		getEnd();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::AssemblyConnector", "end");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_end != null) {
			_end.add(val);
		}
	}

	@Override
	public <T extends ConnectorEnd> T addEnd(Class<T> typeToCreate,
			String concept) {
		// make sure the end list is created
		getEnd();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::AssemblyConnector", "end",
				concept);
		T element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, typeToCreate);
		if (_end != null) {
			_end.add(element);
		}
		return element;
	}

	@Override
	public ConnectorEnd addEnd() {
		// make sure the end list is created
		getEnd();
		org.eclipse.emf.ecore.EObject newConcept = ZDLUtil.createZDLConcept(
				element, "ZMLMM::ZML_Component::AssemblyConnector", "end",
				"ZMLMM::ZML_Component::ConnectorEnd");
		ConnectorEnd element = ZDLFactoryRegistry.INSTANCE.create(
				newConcept, ConnectorEnd.class);
		if (_end != null) {
			_end.add(element);
		}
		return element;
	}

	@Override
	public java.util.List<Port> getPortEnd() {
		if (_portEnd == null) {
			final Object rawValue = com.zeligsoft.base.zdl.util.ZDLUtil
					.getValue(eObject(),
							"ZMLMM::ZML_Component::AssemblyConnector",
							"portEnd");
			_portEnd = new java.util.ArrayList<Port>();
			@SuppressWarnings("unchecked")
			final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
			for (Object next : rawList) {
				if (next instanceof org.eclipse.emf.ecore.EObject) {
					Port nextWrapper = ZDLFactoryRegistry.INSTANCE.create(
							(org.eclipse.emf.ecore.EObject) next, Port.class);
					_portEnd.add(nextWrapper);
				}
			}
		}
		return _portEnd;
	}

	@Override
	public void addPortEnd(Port val) {
		// make sure the portEnd list is created
		getPortEnd();

		final Object rawValue = ZDLUtil.getValue(element,
				"ZMLMM::ZML_Component::AssemblyConnector", "portEnd");
		@SuppressWarnings("unchecked")
		final java.util.List<Object> rawList = (java.util.List<Object>) rawValue;
		rawList.add(val.eObject());
		if (_portEnd != null) {
			_portEnd.add(val);
		}
	}

	@Override
	public org.eclipse.uml2.uml.Connector asConnector() {
		return (org.eclipse.uml2.uml.Connector) eObject();
	}
}
