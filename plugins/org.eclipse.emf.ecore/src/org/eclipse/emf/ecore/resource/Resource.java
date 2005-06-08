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
 * $Id: Resource.java,v 1.2.2.1 2005/06/08 18:27:46 nickb Exp $
 */
package org.eclipse.emf.ecore.resource;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;


/**
 * A persistent document.
 * <p>
 * A resource of an appropriate type is {@link Factory#createResource created} by a resource factory;
 * a resource set indirectly {@link ResourceSet#createResource creates} a resource using such a factory.
 * A resource is typically {@link #getResourceSet contained} by a resource set,
 * along with related resources.
 * It has a {@link #getURI URI} representing it's identity
 * and that URI is {@link org.eclipse.emf.ecore.resource.URIConverter used}
 * to determine where to {@link #save(Map) save} and {@link #load(Map) load}.
 * It provides modeled {@link #getContents contents},
 * in fact, it provides even the {@link #getAllContents tree} of modeled contents,
 * as well as {@link Diagnostic diagnostics} for {@link #getErrors errors} and {@link #getWarnings other} problems.
 * It may be {@link #unload unloaded} to discard the contents and the load state can be {@link #isLoaded queried}.
 * {@link #isModified Modification} can be {@link #isTrackingModification tracked}, but it's expensive.
 * The resource will be informed
 * as objects are {@link Resource.Internal#attached attached} and {@link Resource.Internal#detached detached};
 * if needed, it will be able to maintain a map to support {@link #getEObject getEObject}.
 * Structured URI {@link #getURIFragment fragments} are used rather than IDs, since they are a more general alternative.
 * Clients will typically extend the default {@link org.eclipse.emf.ecore.resource.impl.ResourceImpl implementation},
 * or one of it's derived classes.
 * </p>
 * <p>
 * A resource produces notification for changes to the value of each of these features:
 * <ul>
 *   <li>{@link #getResourceSet}</li>
 *   <li>{@link #getURI}</li>
 *   <li>{@link #getContents}</li>
 *   <li>{@link #isModified}</li>
 *   <li>{@link #isLoaded}</li>
 *   <li>{@link #isTrackingModification}</li>
 *   <li>{@link #getErrors}</li>
 *   <li>{@link #getWarnings}</li>
 * </ul>
 * </p>
 * <p>
 * </p>
 * @see org.eclipse.emf.common.notify
 * @see org.eclipse.emf.ecore.resource.impl.ResourceImpl
 * @see Factory
 * @see ResourceSet
 * @see URIConverter
 */
public interface Resource extends Notifier
{
  /**
   * The {@link #getResourceSet} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__RESOURCE_SET = 0;

  /**
   * The {@link #getURI} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__URI = 1;

  /**
   * The {@link #getContents} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__CONTENTS = 2;

  /**
   * The {@link #isModified} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__IS_MODIFIED = 3;

  /**
   * The {@link #isLoaded} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__IS_LOADED = 4;

  /**
   * The {@link #isTrackingModification} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__IS_TRACKING_MODIFICATION = 5;

  /**
   * The {@link #getErrors} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__ERRORS = 6;

  /**
   * The {@link #getWarnings} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
   */
  int RESOURCE__WARNINGS = 7;

  /**
   * Returns the containing resource set.
   * A resource is contained by a resource set
   * if it appears in the {@link ResourceSet#getResources resources}, i.e., the contents, of that resource set.
   * This reference can only be modified by altering the contents of the resource set directly.
   * </p>
   * @return the containing resource set.
   * @see EObject#eContainer
   * @see EObject#eResource
   * @see ResourceSet#getResources
   */
  ResourceSet getResourceSet();

  /**
   * Returns the URI of this resource.
   * The URI is normally expected to be {@link URI#isRelative absolute} and {@link URI#isHierarchical hierarchical};
   * document-relative references will not be serialized and will not be {@link URI#resolve resolved},
   * if this is not the case.
   * @return the URI of this resource.
   * @see #setURI(URI)
   * @see URI#isRelative
   * @see URI#isHierarchical
   */
  URI getURI();

  /**
   * Sets the URI of this resource.
   * @param uri the new URI.
   * @see #getURI
   */
  void setURI(URI uri);

  /**
   * Returns the list of the direct content objects;
   * each is of type {@link EObject}.
   * <p>
   * The contents may be directly modified.
   * Removing an object will have the same effect as
   * {@link org.eclipse.emf.ecore.util.EcoreUtil#remove(EObject) EcoreUtil.remove(EObject)}.
   * Adding an object will remove it from the previous container;
   * it's {@link EObject#eContainer container} will be <code>null</code>
   * and it's {@link EObject#eResource resource} will the <code>this</code>.
   * </p>
   * @return the direct content objects.
   */
  EList getContents();

  /**
   * Returns a tree iterator that iterates over all the {@link #getContents direct contents} and indirect contents of this resource.
   * @return a tree iterator that iterates over all contents.
   * @see EObject#eAllContents
   * @see ResourceSet#getAllContents
   * @see org.eclipse.emf.ecore.util.EcoreUtil#getAllContents
   */
  TreeIterator getAllContents();

  /**
   * Returns the URI {@link URI#fragment fragment} that,
   * when passed to {@link #getEObject getEObject} will return the given object.
   * <p>
   * In other words,
   * the following is <code>true</code> for any object contained by a resource:
   *<pre>
   *   Resource resource = eObject.eResource();
   *   eObject == resource.getEObject(resource.getURIFragment(eObject))
   *</pre>
   * An implementation may choose to use IDs
   * or to use structured URI fragments, as supported by
   * {@link org.eclipse.emf.ecore.InternalEObject#eURIFragmentSegment eURIFragmentSegment}.
   * </p>
   * @param eObject the object to identify.
   * @return the URI {@link URI#fragment fragment} for the object.
   * @see #getEObject(String)
   * @see org.eclipse.emf.ecore.InternalEObject#eURIFragmentSegment(org.eclipse.emf.ecore.EStructuralFeature, EObject)
   */
  String getURIFragment(EObject eObject);


  /**
   * Returns the resolved object for the given URI {@link URI#fragment fragment}.
   * <p>
   * The fragment encoding will typically be that produced by {@link #getURIFragment getURIFragment}.
   * </p>
   * @param uriFragment the fragment to resolve.
   * @return the resolved object for the given fragment.
   * @see #getURIFragment(EObject)
   * @see ResourceSet#getEObject(URI, boolean)
   * @see org.eclipse.emf.ecore.util.EcoreUtil#resolve(EObject, ResourceSet)
   * @see org.eclipse.emf.ecore.InternalEObject#eObjectForURIFragmentSegment(String)
   * @throws org.eclipse.emf.common.util.WrappedException if a problem occurs navigating the fragment.
   */
  EObject getEObject(String uriFragment);

  /**
   * Saves the resource using the specified options.
   * <p>
   * Options are handled generically as feature-to-setting entries;
   * the resource will ignore options it doesn't recognize.
   * The options could even include things like an Eclipse progress monitor...
   * </p>
   * <p>
   * An implementation typically uses the {@link ResourceSet#getURIConverter URI converter}
   * of the {@link #getResourceSet containing} resource set
   * to {@link URIConverter#createOutputStream create} an output stream,
   * and then delegates to {@link #save(OutputStream, Map) save(OutputStream, Map)}.
   * </p>
   * @param options the save options.
   * @see #save(OutputStream, Map)
   */
  void save(Map options) throws IOException;

  /**
   * Loads the resource using the specified options.
   * <p>
   * Options are handled generically as feature-to-setting entries;
   * the resource will ignore options it doesn't recognize.
   * The options could even include things like an Eclipse progress monitor...
   * </p>
   * <p>
   * An implementation typically uses the {@link ResourceSet#getURIConverter URI converter}
   * of the {@link #getResourceSet containing} resource set
   * to {@link URIConverter#createInputStream create} an input stream,
   * and then delegates to {@link #load(InputStream, Map) load(InputStream, Map)}.
   * </p>
   * <p>
   * When the load completes, the {@link #getErrors errors} and {@link #getWarnings warnings} can be consulted.
   * An implementation will typically deserialize as much of a document as possible
   * while producing diagnostics for any problems that are encountered.
   * </p>
   * @param options the load options.
   * @see #load(InputStream, Map)
   */
  void load(Map options) throws IOException;

  /**
   * Saves the resource to the output stream using the specified options.
   * <p>
   * Usually, {@link #save(Map) save(Map)} is called directly and it calls this.
   * </p>
   * @param outputStream the stream
   * @param options the save options.
   * @see #save(Map)
   * @see #load(InputStream, Map)
   */
  void save(OutputStream outputStream, Map options) throws IOException;

  /**
   * Loads the resource from the input stream using the specified options.
   * <p>
   * Usually, {@link #load(Map) load(Map)} is called directly and it calls this.
   * </p>
   * @param inputStream the stream
   * @param options the load options.
   * @see #load(Map)
   * @see #save(OutputStream, Map)
   */
  void load(InputStream inputStream, Map options) throws IOException;

  /**
   * Returns whether modification tracking is enabled.
   * <p>
   * If modification tracking is enabled,
   * each object of the resource must be adapted in order to listen for changes.
   * This will make the processing of {@link Resource.Internal#attached attached} 
   * and {@link Resource.Internal#detached detached } significantly more expensive.
   * as well as all model editing, in general.
   * </p>
   * @return whether modification tracking is enabled.
   */
  boolean isTrackingModification();

  /**
   * Sets whether modification tracking is enabled.
   * <p>
   * Calling this method is expensive because it walks the content {@link #getAllContents tree} to add or remove adapters.
   * </p>
   * @param isTrackingModification whether modification tracking is to be enabled.
   */
  void setTrackingModification(boolean isTrackingModification);

  /**
   * Returns whether this resource has been modified.
   * <p>
   * A resource is set to be unmodified after it is loaded or saved.
   * {@link #isTrackingModification Automatic} modification tracking is supported, but it is expensive.
   * Moreover, it is a poor fit for a model that supports undoable commands,
   * since an undo looks like a change when it's really exactly the opposite.
   * </p>
   * @return whether this resource has been modified.
   * @see #setModified(boolean)
   */
  boolean isModified();

  /**
   * Sets whether this resource has been modified.
   * <p>
   * A resource is automatically set to be unmodified after it is loaded or saved.
   * {@link #isTrackingModification Automatic} modification tracking typically calls this directly.
   * </p>
   * @param isModified whether this resource has been modified.
   * @see #isModified
   */
  void setModified(boolean isModified);

  /**
   * Returns whether the resource is loaded.
   * <p>
   * This will be <code>false</code> when the resource is first {@link ResourceSet#createResource created}
   * and will be set to <code>false</code>, when the resource is {@link #unload unloaded}.
   * It will be set to <code>true</code> when the resource is {@link #load(Map) loaded}
   * and when {@link #getContents contents} are first added to a resource that isn't loaded.
   * Calling {@link org.eclipse.emf.common.util.BasicEList#clear clear}
   * for the {@link #getContents contents} of a resource that isn't loaded,
   * will set the resource to be loaded;
   * this is the simplest way to create an empty resource that's considered loaded.
   * </p>
   * @return whether the resource is loaded.
   */
  boolean isLoaded();

  /**
   * Clears the {@link #getContents contents},
   * {@link #getErrors errors},
   * and {@link #getWarnings warnings} of the resource
   * and {@link #isLoaded marks} it as unloaded.
   * <p>
   * It walks the content {@link #getAllContents tree},
   * and {@link org.eclipse.emf.ecore.InternalEObject#eSetProxyURI sets} each content object to be a proxy.
   * The resource will remain in the {@link #getResourceSet resource set},
   * and can be subsequently reloaded.
   * </p>
   */
  void unload();

  /**
   * Returns a list of the errors in the resource;
   * each error will be of type {@link org.eclipse.emf.ecore.resource.Resource.Diagnostic}.
   * <p>
   * These will typically be produced as the resource is {@link #load(Map) loaded}.
   * </p>
   * @return a list of the errors in the resource.
   * @see #load(Map)
   */
  EList getErrors();

  /**
   * Returns a list of the warnings and informational messages in the resource;
   * each warning will be of type {@link org.eclipse.emf.ecore.resource.Resource.Diagnostic}.
   * <p>
   * These will typically be produced as the resource is {@link #load(Map) loaded}.
   * </p>
   * @return a list of the warnings in the resource.
   * @see #load(Map)
   */
  EList getWarnings();

  /**
   * A noteworthy issue in a document.
   */
  interface Diagnostic
  {
    /**
     * Returns a translated message describing the issue.
     * @return a translated message.
     */
    String getMessage();

    /**
     * Returns the source location of the issue.
     * This will typically be just the  {@link Resource#getURI URI} of the resource containing this diagnostic.
     * @return the location of the issue.
     */
    String getLocation();

    /**
     * Returns the line location of the issue within the source.
     * Line <code>1</code> is the first line.
     * @return the line location of the issue.
     */
    int getLine();

    /**
     * Returns the column location of the issue within the source.
     * Column <code>1</code> is the first column.
     * @return the column location of the issue.
     */
    int getColumn();
  }

  /**
   * A factory for creating resources.
   * <p>
   * A factory is implemented to {@link #createResource create} a specialized type of resource
   * and is typically registered in {@link Resource.Factory.Registry registry}.
   * </p>
   * @see ResourceSet#createResource(URI)
   */
  interface Factory
  {
    /**
     * Creates a resource with the given URI and returns it.
     * <p>
     * Clients will typically not call this directly themselves;
     * it's called by the resource set to {@link ResourceSet#createResource create} a resource.
     * </p>
     * @param uri the URI.
     * @return a new resource.
     * @see ResourceSet#createResource(URI)
     */
    Resource createResource(URI uri);

    /**
     * A descriptor used by a resource factory registry to defer factory creation.
     * <p>
     * The creation is defered until the factory is {@link Resource.Factory.Registry#getFactory fetched} for the first time.
     * </p>
     * @see Resource.Factory.Registry#getFactory(URI)
     */
    interface Descriptor
    {
      /**
       * Creates a factory and returns it.
       * <p>
       * An implementation may and usually does choose to create only one instance,
       * which it returns for each call.
       * </p>
       * @return a factory.
       */
      Factory createFactory();
    }

    /**
     * A registry of resource factories.
     * <p>
     * A registry implementation will typically delegate to the global instance, which can be used as follows
     *<pre>
     *  Resource.Factory.Registry.{@link Resource.Factory.Registry#INSTANCE INSTANCE}.getProtocolToFactoryMap().
     *    put("abc", resourceFactoryForURIWithAbcProtocol);
     *  Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().
     *    put("xyz", resourceFactoryForURIWithXyzFileExtension);
     *</pre>
     * A {@link Resource.Factory.Descriptor descriptor} can be used in place of an actual {@link Resource.Factory factory}
     * as a value in the map.
     * It is used for factories registered via
     * {@link org.eclipse.emf.ecore.plugin.EcorePlugin.Implementation#startup plugin registration}
     * to ensure delayed plugin load.
     * </p>
     * @see ResourceSet#getResourceFactoryRegistry()
     */
    interface Registry
    {
      /**
       * Returns the resource factory appropriate for the given URI.
       * <p>
       * An implementation will (typically) use
       * the URI's {@link URI#scheme scheme} to search the {@link #getProtocolToFactoryMap protocol} map
       * and the URI's {@link URI#fileExtension file extension} to search {@link #getExtensionToFactoryMap extension} map.
       * It will {@link org.eclipse.emf.ecore.resource.Resource.Factory.Descriptor#createFactory convert}
       * a resulting descriptor into a factory.
       * It may choose to provide additional mechanisms and algorithms to determine a factory appropriate for the given URI.
       * </p>
       * @param uri the URI.
       * @return the resource factory appropriate for the given URI.
       * @see ResourceSet#createResource(URI)
       */
      Factory getFactory(URI uri);

      /**
       * Returns a map from {@link URI#scheme protocol} to
       * {@link org.eclipse.emf.ecore.resource.Resource.Factory}
       * or {@link org.eclipse.emf.ecore.resource.Resource.Factory.Descriptor}.
       * @return the protocol map.
       */
      Map getProtocolToFactoryMap();

      /**
       * The file extension <code>"*"</code> that matches any extension.
       * @see #getExtensionToFactoryMap
       */
      String DEFAULT_EXTENSION = "*";

      /**
       * Returns a map from {@link URI#fileExtension file extension} to
       * {@link org.eclipse.emf.ecore.resource.Resource.Factory}
       * or {@link org.eclipse.emf.ecore.resource.Resource.Factory.Descriptor}.
       * <p>
       * The {@link #DEFAULT_EXTENSION default} file extension <code>"*"</code> 
       * can be registered as a default that matches any file extension.
       * This is typically reserved for a default factory that supports XMI serialization;
       * clients are strongly discouraged from using this feature in the global registry,
       * particularly those that must function effectively within an Eclipse environment.
       * </p>
       * @return the file extension map.
       * @see #DEFAULT_EXTENSION
       */
      Map getExtensionToFactoryMap();

      /**
       * The global static resource factory registry.
       * Registrations made in this instance will (typically) be available
       * for {@link ResourceSet#createResource use} by any resource set.
       * @see ResourceSet#createResource(URI)
       * @see ResourceSet#getResourceFactoryRegistry()
       */
      Registry INSTANCE = new ResourceFactoryRegistryImpl();

    }
  }

  /**
   * An IO exception that wraps another exception.
   * <p>
   * Since save and load throw an IO Exception,
   * it may be convenient for an implementation to wrap another exception
   * in order to throw it as an IO exception.
   * </p>
   */
  class IOWrappedException extends IOException
  {
    /**
     * The wrapped exception.
     */
    protected Exception exception;

    /**
     * Creates an instance which wraps the given exception.
     * @param exception the exception to wrap.
     */
    public IOWrappedException(Exception exception)
    {
      super(exception.getLocalizedMessage());
      this.exception = exception;
    }

    /**
     * Returns the wrapped exception.
     * @return the wrapped exception.
     */
    public Exception getWrappedException()
    {
      return exception;
    }

    /**
     * Returns the localized message of the wrapped exception.
     * @return the localized message of the wrapped exception.
     */
    public String getLocalizedMessage()
    {
      return exception.getLocalizedMessage();
    }

    /**
     * Returns the message of the wrapped exception.
     * @return the message of the wrapped exception.
     */
    public String getMessage()
    {
      return exception.getMessage();
    }

    /**
     * Prints the stack trace of the wrapped exception.
     */
    public void printStackTrace()
    {
      exception.printStackTrace();
    }

    /**
     * Prints the stack trace of the wrapped exception.
     * @param printStream the stream to print to.
     */
    public void printStackTrace(PrintStream printStream)
    {
      exception.printStackTrace(printStream);
    }

    /**
     * Prints the stack trace of the wrapped exception.
     * @param printWriter the writer to print to.
     */
    public void printStackTrace(PrintWriter printWriter)
    {
      exception.printStackTrace(printWriter);
    }
  }

  /**
   * An internal interface implemented by all resources.
   * <p>
   * It is used to maintain the referential integrity of
   * the containment relation between a resource set and a resource.
   * </p>
   * @see Resource#getResourceSet
   * @see ResourceSet#getResources
   * @see org.eclipse.emf.ecore.InternalEObject#eBasicSetContainer(org.eclipse.emf.ecore.InternalEObject, int, NotificationChain)
   *  InternalEObject.eBasicSetContainer(InternalEObject, int, NotificationChain)
   */
  interface Internal extends Resource
  {
    /**
     * Called when the object is attached to this resource,
     * i.e., when it's {@link EObject#eResource eResource} changes to be this one.
     * <p>
     * An implementation that {@link #getEObject resolves} based on IDs
     * will need to walk the {@link EObject#eAllContents tree} of this object
     * in order to tabulate an index.
     * An implementation that needs to {@link #isTrackingModification track modification}
     * will also need to walk the tree
     * in order to add the necessary adapter.
     * In either of these cases,
     * editing of containment relations will be significantly more expensive.
     * </p>
     * @param eObject the attached object.
     * @see #detached(EObject)
     */
    void attached(EObject eObject);

    /**
     * Called when the object is detached from this resource,
     * i.e., when it's {@link EObject#eResource eResource} changes to no longer be this one.
     * <p>
     * An implementation that {@link #getEObject resolves} based on IDs
     * will need to walk the {@link EObject#eAllContents tree} of this object
     * in order clean up it's index.
     * An implementation that needs to {@link #isTrackingModification track modification}
     * will also need to walk the tree
     * in order to remove the added adapter.
     * In either of these cases,
     * editing of containment relations will be significantly more expensive.
     * </p>
     * @param eObject the attached object.
     * @see #attached(EObject)
     */
    void detached(EObject eObject);

    /**
     * Sets the resource to be contained by the given resource set, and returns the notifications this produces.
     * <p>
     * If it was previously contained by a resource set, it will have been removed.
     * </p>
     * @return the notifications produced.
     */
    NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications);
  }
}
