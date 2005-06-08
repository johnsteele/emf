/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EMFTestEditPlugin.java,v 1.2.2.2 2005/06/08 18:27:44 nickb Exp $
 */
package org.eclipse.emf.test.edit;

import org.eclipse.core.runtime.Plugin;

public class EMFTestEditPlugin 
extends Plugin
{
    private static EMFTestEditPlugin instance;
    private static class Foo{};
    
    public EMFTestEditPlugin()
    {
        super();
        instance = this;
    }

    public static EMFTestEditPlugin getPlugin()
    {
        return instance;
    }
}
