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
package com.zeligsoft.domain.zml.api.ZML_HwPlatform;

import com.zeligsoft.base.zdl.staticapi.core.ZObject;
import com.zeligsoft.base.zdl.staticapi.functions.TypeSelectPredicate;

public interface HwCommunicationEndPoint extends ZObject {
	org.eclipse.uml2.uml.ConnectableElement asConnectableElement();

	/**
	 * A predicate which returns true if the Object is an
	 * instance of HwCommunicationEndPoint
	 */
	static final TypeSelectPredicate<HwCommunicationEndPoint> type = new TypeSelectPredicate<HwCommunicationEndPoint>(
			"ZMLMM::ZML_HwPlatform::HwCommunicationEndPoint", //$NON-NLS-1$
			HwCommunicationEndPoint.class);
}
