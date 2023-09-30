import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';

class Vogais extends StatefulWidget {
  const Vogais({Key? key}) : super(key: key);

  @override
  _VogaisState createState() => _VogaisState();
}

class _VogaisState extends State<Vogais> {
  AudioPlayer _audioPlayer = AudioPlayer();

  String pp = "play";

  Icon _icone = const Icon(Icons.play_arrow);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        children: [
          IconButton(
            onPressed: () {
              if (pp.contains("play")) {
                String url =
                    "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3";
                _audioPlayer.play(url);
                setState(() {
                  pp = "pause";
                  _icone = const Icon(Icons.pause);
                });
              } else {
                _audioPlayer.pause();
                setState(() {
                  pp = "play";
                  _icone = const Icon(Icons.play_arrow);
                });
              }
            },
            icon: _icone,
          ),
          IconButton(
            onPressed: () {
              _audioPlayer.stop();
            },
            icon: const Icon(Icons.stop),
          ),
        ],
      ),
    );
  }
}
