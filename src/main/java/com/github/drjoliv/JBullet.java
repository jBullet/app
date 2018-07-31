package com.github.drjoliv;

import java.util.ArrayList;
import java.util.List;

public final class JBullet implements PlatformServices {

  private static final JBullet INSTANCE = new JBullet();

  private PluginManager manager = PluginManager.instance();

  private List<PlatformObserver> observers = new ArrayList<>();

  private JBullet(){}

  @Override
  public List<Object> create(List<Object> items) {
    throw new UnsupportedOperationException("JBullet::create is unsupported");
  }

  @Override
  public List<Object> delete(List<Object> items) {
    throw new UnsupportedOperationException("JBullet::delete is unsupported");
  }

  @Override
  public List<Object> read(List<String> ids) {
    throw new UnsupportedOperationException("JBullet::read is unsupported");
  }

  @Override
  public List<Object> all(String type) {
    throw new UnsupportedOperationException("JBullet::read is unsupported");
  }

  @Override
  public List<Object> update(List<Object> items) {
    throw new UnsupportedOperationException("JBullet::update is unsupported");
  }

  private void notify(Event event) {
    for (PlatformObserver o : observers) {
      o.onNotify(event);
    }
  }

  public void dispatch(String[] args) {
    manager.dispatch(args);
  }

  public static JBullet instance() {
    return INSTANCE;
  }

  @Override
  public void attach(PlatformObserver o) {
    observers.add(o);
  }

  @Override
  public void detach(PlatformObserver o) {
    observers.remove(o);
  }
}
