/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {useEffect} from 'react';
import {StyleSheet, View, Button} from 'react-native';

import ToastExample from './ToastExample';

const App = () => {
  useEffect(() => {
    ToastExample.show('AweSome', ToastExample.SHORT);
  }, []);

  function _onPressButton() {
    ToastExample.doCallbackTask(
      100,
      (name, email, age) => {
        ToastExample.show(
          `Result: Name=${name},
      Email=${email}, age=${age}`,
          ToastExample.LONG,
        );
      },
      errorMessage => {
        ToastExample.show(`Error:${errorMessage}`, ToastExample.LONG);
      },
    );
  }
  // function _JAVAView() {
  //   DeviceEventEmitter.addListener('eventA', event => {
  //     ToastExample.show(
  //       `Received evet: ${JSON.stringify(event)}`,
  //       ToastExample.LONG,
  //     );
  //   });
  // }

  async function _onPromise() {
    try {
      let result = await ToastExample.doPromiseTask(100);
      ToastExample.show(
        `Result ==> ${JSON.stringify(result)}`,
        ToastExample.LONG,
      );
    } catch (error) {
      ToastExample.show(`Error: ${error}`, ToastExample.SHORT);
    }
  }

  return (
    <View style={styles.container}>
      <Button title="Callback" onPress={_onPressButton} />
      <Button title="Promise" onPress={_onPromise} />
      {/* <Button title="fromJAVA" onPress={_JAVAView} /> */}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});

export default App;
