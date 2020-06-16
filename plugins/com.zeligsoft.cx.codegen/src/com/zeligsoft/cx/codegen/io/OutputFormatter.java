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
package com.zeligsoft.cx.codegen.io;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.ToolFactory;
import org.eclipse.cdt.core.formatter.CodeFormatter;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.osgi.util.NLS;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xpand2.output.FileHandle;

import com.zeligsoft.cx.codegen.CodeGenPlugin;
import com.zeligsoft.cx.codegen.l10n.Messages;

public class OutputFormatter {

	private static final int MAX_MAKEFILE_BLANK_LINES = 2;
	
	/**
	 * Formats .c and .h files generated by the CX
	 */		
	@SuppressWarnings("deprecation")
	static public void formatCFile( FileHandle file ) {

		// do nothing if the CDT plugin is not loaded
		if (Platform.getBundle(CCorePlugin.PLUGIN_ID) == null)
			return;

		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
		IDocument doc = new Document(file.getBuffer().toString());
		
		TextEdit edit = codeFormatter.format(
			CodeFormatter.K_TRANSLATION_UNIT, doc.get(), 0, doc.get().length(),
			0, null);

		if (edit == null) {
			CodeGenPlugin.getDefault()
				.error( NLS.bind( Messages.Formatter_CantFormat, file.getTargetFile() ), null );
			return;
		}

		try {
			edit.apply(doc);
			file.setBuffer(new StringBuffer(doc.get()));
		} catch (MalformedTreeException e) {
			CodeGenPlugin.getDefault()
				.error( NLS.bind( Messages.Formatter_IllegalTree, e.getMessage() ), e );			
		} catch (BadLocationException e) {
			CodeGenPlugin.getDefault()
				.error( NLS.bind( Messages.Formatter_BadLocation, e.getMessage() ), e );			
		}
	}

	/**
	 * Formats makefiles and makefile fragments generated by the CX
	 */		
	static public void formatMakefile( FileHandle file ) {

		IDocument doc = new Document( file.getBuffer().toString() );
		int lines = doc.getNumberOfLines();
		if ( lines > 0 ) {
			try {
				StringBuffer buffer = new StringBuffer( doc.getLength() );
				int empty = 0;
	
				// assume same end of line for all lines in file
				String eol = doc.getLineDelimiter( 0 );
				
				for ( int lineNo = 0; lineNo < lines; lineNo++ ) {
				
					IRegion region = doc.getLineInformation( lineNo );
					String str = doc.get( region.getOffset(), region.getLength() );
					
					// keep track of blank lines
					if ( str.trim().length() == 0 ) {
						str = "";	//$NON-NLS-1$
						empty++;
					} else {
						empty = 0;
					}
					
					// don't write too many blank lines
					if ( empty < MAX_MAKEFILE_BLANK_LINES ) {
						buffer.append( str + eol );
					}
				}
				
				file.setBuffer( buffer );
				
			} catch( BadLocationException ble ) {
				ble.printStackTrace();			
			}
		}
	}

}
