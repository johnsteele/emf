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
 * $Id: Disposable.java,v 1.1.2.1 2005/06/08 18:27:42 nickb Exp $
 */
package org.eclipse.emf.edit.provider;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


/**
 * This implements {@link IDisposable} as a set IDisposables that can in turn be disposed.
 */
public class Disposable extends HashSet implements IDisposable
{
  /**
   * This creates an empty instance.
   */
  public Disposable()
  {
  }

  /**
   * This creates an instance with containing all the given disposables.
   */
  public Disposable(Collection disposables)
  {
    super(disposables);
  }

  /**
   * This is called to dispose the disposables.
   */
  public void dispose()
  {
    for (Iterator disposables = iterator(); disposables.hasNext(); )
    {
      IDisposable disposable = (IDisposable)disposables.next();
      disposable.dispose(); 
    }
    clear();
  }

  public boolean add(Object object)
  {
    if (object instanceof IDisposable)
    {
      return super.add(object);
    }
    else
    {
      return false;
    }
  }

  public boolean addAll(Collection collection)
  {
    boolean result = false;
    for (Iterator objects = collection.iterator(); objects.hasNext(); )
    {
      Object object = objects.next();
      if (add(object))
      {
        result = true;
      }
    }
    return result;
  }
}
