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
package com.zeligsoft.cx.langc;

import org.eclipse.emf.ecore.EObject;

import com.zeligsoft.cx.codegen.io.IWritable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * @extends IWritable
 * <!-- end-user-doc -->
 *
 *
 * @see com.zeligsoft.cx.langc.LangCPackage#getDependency()
 * @model abstract="true"
 * @generated
 */
public interface Dependency extends EObject, IWritable {
	public boolean refersTo( ElementList elementList );
} // Dependency
