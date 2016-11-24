"use strict";

const newman = require('newman');

var config = JSON.parse(process.argv[2]);

newman.run(config, function(err, summary) {
    if (err) {
       console.log(JSON.stringify(err, null, 1));
       var failed = true;
    } else {
       var failed = summary.run.failures && summary.run.failures.length > 0;
    }

    if (failed) {
        process.exit(1);
    }
});