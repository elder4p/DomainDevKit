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

package com.zeligsoft.cx.ui.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

import com.zeligsoft.base.ui.utils.BaseUIUtil;

/**
 * Label provider class for the PropertyEntry
 * 
 * @author ysroh
 * 
 */
public class PropertyEntryLabelProvider
		extends LabelProvider
		implements ITableLabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object,
	 *      int)
	 */
	@Override
	public String getColumnText(Object object, int index) {
		if (!(object instanceof IPropertyEntry)) {
			return UML2Util.EMPTY_STRING; 
		}
		IPropertyEntry entry = (IPropertyEntry) object;
		return entry.getPropertyColumnLabel(index);
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == 0 && element instanceof IPropertyEntry) {
			EObject modelObject = ((IPropertyEntry) element).getModelObject();
			if (modelObject instanceof ValueSpecification) {
				StructuralFeature feature = ((Slot) modelObject.eContainer())
						.getDefiningFeature();
				if (feature.getType() != null) {
					return BaseUIUtil.getIcon(feature.getType());
				}
			}
			return BaseUIUtil.getIcon(((IPropertyEntry) element)
					.getModelObject());
		}
		return null;
	}
}
