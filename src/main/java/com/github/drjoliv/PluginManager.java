package com.github.drjoliv;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ServiceLoader;
import com.github.drjoliv.spi.*;

public final class PluginManager {

  private static final PluginManager INSTANCE = new PluginManager();

  private HashMap<String, Plugin> plugins = new HashMap<>();
  private JBullet jBullet = JBullet.instance();


  private PluginManager() {
    initPlugins();
  }

  private void initPlugins() {
    String path = System.getProperty("user.home") + "/.jbullet/plugins";
    System.out.println(path);
    File pluginFolder = new File(path);
    pluginFolder.mkdirs();

    ServiceLoader<Plugin> loader = null;
    try {
      loader = ServiceLoader.load(Plugin.class
          , new URLClassLoader(new URL[] { pluginFolder.toURI().toURL() }));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    if(loader != null) {
      loader.iterator()
      .forEachRemaining(p -> addPlugin(p));
    }
  }

  public void addPlugin(Plugin plugin) {
    Class<?> cls =  plugin.getClass();
    PluginInfo p = cls.getAnnotation(PluginInfo.class);
    if(p != null) {
      if(plugins.containsKey(p.name()))
        plugins.put(cls.getCanonicalName() +":" + p.name(), plugin);
      else
        plugins.put(p.name(), plugin);
      plugin.attach(jBullet);
    }
  }

  public static synchronized PluginManager instance() {
    return INSTANCE;
  }

  public void dispatch(String[] args) {
    if(args.length > 0) {
      plugins.getOrDefault(args[0], new NotFound())
        .run(Arrays.copyOfRange(args, 1, args.length));
    }
  }


  private static class NotFound implements Plugin {

    @Override
    public void attach(PlatformServices arg0) {}

    @Override
    public void run(String[] arg0) {
      System.out.println("dispatched");
    }

    @Override
    public void onNotify(Event arg0) {}
  }
}
