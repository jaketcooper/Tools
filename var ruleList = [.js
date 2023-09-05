      var ruleList = [
          {
            desc: "Your password must be at least 5 characters.",
            test: function (e, t) {
              return { isValid: t.passwordLength >= 5 };
            },
            id: "min-length",
          },
          {
            desc: "Your password must include a number.",
            test: function (e) {
              return { isValid: /\d/.test(e) };
            },
            id: "number",
          },
          {
            desc: "Your password must include an uppercase letter.",
            test: function (e) {
              return { isValid: /[A-Z]/.test(e) };
            },
            id: "uppercase",
          },
          {
            desc: "Your password must include a special character.",
            test: function (e) {
              return { isValid: /[^a-zA-Z0-9]/.test(e) };
            },
            id: "special",
          },
          {
            desc: "The digits in your password must add up to 25.",
            test: function (e) {
              var t = (function (e) {
                  var t = e.match(/\d/g) || [],
                    r = t.map(function (e) {
                      return parseInt(e);
                    });
                  return { strArr: t, numArr: r };
                })(e),
                r = (t.strArr, t.numArr);
              return (
                0 !== r.length && {
                  isValid:
                    25 ===
                    r.reduce(function (a, b) {
                      return a + b;
                    }),
                }
              );
            },
            highlight: x,
            id: "digits",
          },
          {
            desc: "Your password must include a month of the year.",
            test: function (e) {
              var t = e.toLowerCase();
              return {
                isValid: [
                  "january",
                  "february",
                  "march",
                  "april",
                  "may",
                  "june",
                  "july",
                  "august",
                  "september",
                  "october",
                  "november",
                  "december",
                ].some(function (e) {
                  return t.includes(e);
                }),
                explain: "",
              };
            },
            id: "month",
          },
          {
            desc: "Your password must include a roman numeral.",
            test: function (e) {
              return { isValid: R(e).length > 0 };
            },
            id: "roman",
          },
          {
            desc: "Your password must include one of our sponsors:",
            test: function (e) {
              var t = e.toLowerCase();
              return {
                isValid: ["pepsi", "starbucks", "shell"].some(function (e) {
                  return t.includes(e);
                }),
              };
            },
            id: "sponsors",
          },
          {
            desc: "The roman numerals in your password should multiply to 35.",
            test: function (e) {
              var t = R(e);
              if (0 === t.length) return !1;
              for (var r = y(t[0]) || 0, i = 1; i < t.length; i++) r *= y(t[i]);
              return { isValid: 35 === r };
            },
            id: "roman-multiply",
            highlight: k,
          },
          {
            desc: "Your password must include this CAPTCHA:",
            test: function (e, t) {
              var r = t.currCaptcha;
              return { isValid: e.includes(r) };
            },
            id: "captcha",
          },
          {
            desc: "Your password must include today's Wordle answer.",
            test: function (e, t) {
              var r = t.wordleAnswer,
                o = t.tomorrowWordleAnswer,
                n = e.toLowerCase();
              return { isValid: n.includes(r) || n.includes(o) };
            },
            id: "wordle",
          },
          {
            desc: "Your password must include a two letter symbol from the periodic table.",
            test: function (e) {
              return {
                isValid: l.some(function (t) {
                  return 2 === t.symbol.length && e.includes(t.symbol);
                }),
                explain: "",
              };
            },
            id: "periodic-table",
          },
          {
            desc: "Your password must include the current phase of the moon as an emoji.",
            test: function (e) {
              var t = d.a.getMoonIllumination(m).phase,
                r = d.a.getMoonIllumination(h).phase;
              return {
                isValid: (t <= 0.25 && r >= 0.25
                  ? ["🌓", "🌗", "🌛", "🌜"]
                  : t <= 0.5 && r >= 0.5
                  ? ["🌕", "🌝"]
                  : t <= 0.75 && r >= 0.75
                  ? ["🌓", "🌗", "🌛", "🌜"]
                  : t >= r
                  ? ["🌑", "🌚"]
                  : t <= 0.25
                  ? ["🌒", "🌘"]
                  : t <= 0.5 || t <= 0.75
                  ? ["🌔", "🌖"]
                  : ["🌒", "🌘"]
                ).some(function (t) {
                  return e.includes(t);
                }),
              };
            },
            id: "moon-phase",
          },
          {
            desc: "Your password must include the name of this country.",
            test: function (e, t) {
              var r = t.currPlace,
                o = e.toLowerCase().replaceAll(" ", ""),
                n = r.title.toLowerCase().replaceAll(" ", "");
              return { isValid: o.includes(n) };
            },
            id: "geo",
          },
          {
            desc: "Your password must include a leap year.",
            test: function (e) {
              var t = (function (e) {
                var t = [],
                  r = [],
                  n = e.match(/(\d+)/g) || [];
                t.push.apply(t, Object(o.a)(n)),
                  r.push.apply(
                    r,
                    Object(o.a)(
                      n.map(function (e) {
                        return parseInt(e);
                      })
                    )
                  );
                var l = R(e);
                return (
                  t.push.apply(t, Object(o.a)(l)),
                  r.push.apply(
                    r,
                    Object(o.a)(
                      l.map(function (e) {
                        return y(e);
                      })
                    )
                  ),
                  { strArr: t, numArr: r }
                );
              })(e).numArr;
              return {
                isValid: t.some(function (e) {
                  return (e % 4 == 0 && e % 100 != 0) || e % 400 == 0;
                }),
              };
            },
            id: "leap-year",
          },
          {
            desc: "Your password must include the best move in <a style='color: #ff0000' target='_blank' href='https://en.wikipedia.org/wiki/Algebraic_notation_(chess)'>algebraic chess notation.</a>",
            test: function (e, t) {
              var r = t.currChessPuzzle;
              return { isValid: e.includes(r.sol) };
            },
            id: "chess",
          },
          {
            desc: "🥚 ← This is my chicken Paul. He hasn't hatched yet, please put him in your password and keep him safe.",
            test: function (e, t) {
              var r = t.eggPlaced,
                o = t.triggerDeathAnimation,
                n = t.paulHatched,
                l = e.includes("🥚") || (n && e.includes("🐔"));
              return r && !l && o("Paul has been slain"), { isValid: l };
            },
            id: "egg",
          },
          {
            desc: "The elements in your password must have atomic numbers that add up to 200.",
            test: function (e) {
              var t = 0;
              return (
                [v, P].forEach(function (r) {
                  r.forEach(function (r) {
                    e = e.replaceAll(r.symbol, function (e) {
                      return (t += parseInt(r.num)), "";
                    });
                  });
                }),
                { isValid: 200 === t, explain: "" }
              );
            },
            id: "atomic-number",
            highlight: function (e) {
              for (var t = [], r = 0; r < v.length; r++)
                for (var o = v[r], n = e.indexOf(o.symbol); n > -1; )
                  t.push(n),
                    t.push(n + 1),
                    (n = (e = e.replace(o.symbol, " ".repeat(2))).indexOf(
                      o.symbol
                    ));
              for (var l = 0; l < P.length; l++)
                for (var c = P[l], d = e.indexOf(c.symbol); d > -1; )
                  t.push(d),
                    (d = (e = e.replace(c.symbol, " ")).indexOf(c.symbol));
              return t;
            },
          },
          {
            desc: "All the vowels in your password must be bolded.",
            test: function (e, t) {
              var r = t.doc,
                n = !0,
                l = [];
              return (
                r.descendants(function (e, t) {
                  e.text &&
                    e.text.match(/[aeiouy]/gi) &&
                    (e.marks.some(function (mark) {
                      return "bold" === mark.type.name;
                    }) ||
                      ((n = !1),
                      Object(o.a)(e.text.matchAll(/[aeiouy]/gi)).forEach(
                        function (e) {
                          l.push(t + e.index - 1);
                        }
                      )));
                }),
                { isValid: n, highlights: l }
              );
            },
            id: "bold-vowels",
          },
          {
            desc: "Oh no! Your password is on fire. Quick, put it out!",
            test: function (e, t) {
              var r = t.fireStarted;
              return { isValid: !e.includes("🔥") && r };
            },
            id: "fire",
          },
          {
            desc: "Your password is not strong enough 🏋️‍♂️",
            test: function (e) {
              return Object(o.a)(e.matchAll("🏋️‍♂️")).length >= 3
                ? { isValid: !0 }
                : { isValid: !1 };
            },
            id: "strength",
            hasDelay: !0,
          },
          {
            desc: "Your password must contain one of the following affirmations:",
            test: function (e) {
              var t = ["i am loved", "i am worthy", "i am enough"],
                r = e.toLowerCase();
              return {
                isValid:
                  t.some(function (e) {
                    return r.includes(e);
                  }) ||
                  t.some(function (e) {
                    return r.includes(e.replaceAll(" ", ""));
                  }),
              };
            },
            id: "affirmation",
          },
          {
            desc: "Paul has hatched! Please don't forget to feed him, he eats three 🐛 every minute.",
            test: function (e, t) {
              var r = t.paulEating;
              return { isValid: e.includes("🐛") || r };
            },
            id: "hatch",
          },
          {
            desc: function (e) {
              var t = e.randomYoutubeDuration,
                r = Math.floor(t / 60),
                o = t - 60 * r,
                n = !1,
                l = "";
              return (
                r > 0 && (l += "".concat(r, " minute")),
                o > 0 ? (l += " ".concat(o, " second")) : (n = !0),
                "Your password must include the URL of a"
                  .concat(n ? "n exactly" : "", " ")
                  .concat(l, " long YouTube video.")
              );
            },
            test: function (e, t) {
              var r = t.currYoutubeDuration,
                o = t.randomYoutubeDuration;
              return { isValid: Math.abs(o - r) <= 1 };
            },
            id: "youtube",
            hasDelay: !0,
          },
          {
            desc: "A sacrifice must be made. Pick 2 letters that you will no longer be able to use.",
            test: function (e, t) {
              var r = t.sacraficedLetters;
              if (((e = e.toUpperCase()), 2 !== r.length))
                return { isValid: !1 };
              for (var i = 0; i < r.length; i++)
                if (e.includes(r[i])) return { isValid: !1 };
              return { isValid: !0 };
            },
            highlight: function (e, t) {
              for (
                var r = t.sacraficedLetters, o = e.toUpperCase(), n = [], l = 0;
                l < o.length;
                l++
              )
                r.includes(o[l]) && n.push(l);
              return n;
            },
            id: "sacrafice",
            hasDelay: !0,
          },
          {
            desc: "Your password must contain twice as many italic characters as bold.",
            test: function (e, t) {
              var r = t.doc,
                n = (t.passwordLength, 0),
                l = 0;
              return (
                r.descendants(function (e, t) {
                  e.text &&
                    (e.marks.some(function (mark) {
                      return "bold" === mark.type.name;
                    }) && (n += Object(o.a)(e.text).length),
                    e.marks.some(function (mark) {
                      return "italic" === mark.type.name;
                    }) && (l += Object(o.a)(e.text).length));
                }),
                { isValid: l >= 2 * n }
              );
            },
            id: "twice-italic",
          },
          {
            desc: "At least 30% of your password must be in the Wingdings font.",
            test: function (e, t) {
              var r = t.doc,
                n = t.passwordLength,
                l = 0;
              return (
                r.descendants(function (e, t) {
                  e.text &&
                    e.marks.some(function (mark) {
                      return (
                        "textStyle" === mark.type.name &&
                        "Wingdings" === mark.attrs.fontFamily
                      );
                    }) &&
                    (l += Object(o.a)(e.text).length);
                }),
                { isValid: l / n >= 0.3 }
              );
            },
            id: "wingdings",
          },
          {
            desc: "Your password must include this color in hex.",
            test: function (e, t) {
              var r = t.randomColor,
                o = e.match(/#[0-9A-Fa-f]{6}/g);
              if (!o) return { isValid: !1 };
              for (
                var n = parseInt(r.replace("#", ""), 16), i = 0;
                i < o.length;
                i++
              ) {
                var l = parseInt(o[i].replace("#", ""), 16);
                if (Math.abs(l - n) <= 5) return { isValid: !0 };
              }
              return { isValid: !1 };
            },
            id: "hex",
          },
          {
            desc: "All roman numerals must be in Times New Roman.",
            test: function (e, t) {
              var r = t.doc,
                n = Object(o.a)(e.matchAll(w)),
                l = [],
                c = [];
              n.forEach(function (e) {
                var t = e[0] || e[1] || e[2] || e[3];
                if ("" !== t)
                  for (var r = 0; r < t.length; r++) l.push(e.index + r);
              });
              var d = !0;
              return (
                r.descendants(function (e, t) {
                  if (e.text)
                    for (
                      var r = e.marks.some(function (mark) {
                          return (
                            "textStyle" === mark.type.name &&
                            "Times New Roman" === mark.attrs.fontFamily
                          );
                        }),
                        i = 0;
                      i < Object(o.a)(e.text).length;
                      i++
                    )
                      l.includes(t + i - 1) &&
                        (r || (!0, (d = !1), c.push(t + i - 1)));
                }),
                { isValid: d, highlights: c }
              );
            },
            id: "times-new-roman",
          },
          {
            desc: "The font size of every digit must be equal to its square.",
            test: function (e, t) {
              var r = t.doc,
                n = !0,
                l = [];
              return (
                r.descendants(function (e, t) {
                  if (e.text) {
                    var r,
                      c,
                      mark = e.marks.find(function (mark) {
                        return "textStyle" === mark.type.name;
                      }),
                      d = parseInt(
                        (null == mark ||
                        null === (r = mark.attrs) ||
                        void 0 === r ||
                        null === (c = r.fontSize) ||
                        void 0 === c
                          ? void 0
                          : c.split("px")[0]) || 28
                      );
                    Object(o.a)(e.text.matchAll(/([0-9])/g)).forEach(function (
                      e
                    ) {
                      var r = parseInt(e[0]);
                      r * r !== d && ((n = !1), l.push(t + e.index - 1));
                    });
                  }
                }),
                { isValid: n, highlights: l }
              );
            },
            id: "digit-font-size",
          },
          {
            desc: "Every instance of the same letter must have a different font size.",
            test: function (e, t) {
              var r = t.doc,
                n = !0,
                l = [],
                c = {};
              return (
                r.descendants(function (e, t) {
                  if (e.text) {
                    var r,
                      d,
                      mark = e.marks.find(function (mark) {
                        return "textStyle" === mark.type.name;
                      }),
                      f = parseInt(
                        (null == mark ||
                        null === (r = mark.attrs) ||
                        void 0 === r ||
                        null === (d = r.fontSize) ||
                        void 0 === d
                          ? void 0
                          : d.split("px")[0]) || 28
                      );
                    Object(o.a)(e.text.matchAll(/([a-zA-Z])/g)).forEach(
                      function (e) {
                        var r = e[0].toLowerCase() + f;
                        c[r]
                          ? ((n = !1), l.push(t + e.index - 1))
                          : (c[r] = !0);
                      }
                    );
                  }
                }),
                { isValid: n, highlights: l }
              );
            },
            id: "letter-font-size",
          },
          {
            desc: "Your password must include the length of your password.",
            test: function (e, t) {
              var r = t.passwordLength;
              return { isValid: e.includes(r) };
            },
            id: "include-length",
          },
          {
            desc: "The length of your password must be a prime number.",
            test: function (e, t) {
              for (
                var r = t.passwordLength, i = 2, s = Math.sqrt(r);
                i <= s;
                i++
              )
                if (r % i == 0) return { isValid: !1 };
              return { isValid: r > 1 };
            },
            id: "prime-length",
          },
          {
            desc: "Uhhh let's skip this one.",
            test: function (e) {
              return { isValid: !0 };
            },
            id: "skip",
          },
          {
            desc: "Your password must include the current time.",
            test: function (e) {
              var time = new Date()
                .toLocaleString("en-US", {
                  hour: "numeric",
                  minute: "numeric",
                  hour12: !0,
                })
                .split(" ")[0];
              return { isValid: e.includes(time) };
            },
            id: "time",
          },
          {
            desc: "Is this your final password?",
            test: function (e) {
              return { isValid: !1 };
            },
            id: "final",
          },
        ],